package com.example.MBlock.service;

import com.example.MBlock.domain.Consulting;
import com.example.MBlock.domain.ConsultingReply;
import com.example.MBlock.domain.User;
import com.example.MBlock.domain.type.MessageType;
import com.example.MBlock.dto.Consulting.GetConsultingRes;
import com.example.MBlock.dto.Consulting.WriteConsultingReq;
import com.example.MBlock.dto.ConsultingReply.GetConsultingReplyRes;
import com.example.MBlock.dto.ConsultingReply.WriteConsultingReplyReq;
import com.example.MBlock.dto.Message.MessageReq;
import com.example.MBlock.repository.ConsultingReplyRepository;
import com.example.MBlock.repository.ConsultingRepository;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConsultingService {

    private final ConsultingRepository consultingRepository;

    private final ConsultingReplyRepository consultingReplyRepository;

    private final UserRepository userRepository;

    private final MessageService messageService;

    public void writeConsulting(WriteConsultingReq request) {
        Consulting consulting = Consulting.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .trader(request.getTrader())
                .context(request.getContext())
                .privacy(request.isPrivacy())
                .password(request.getPassword())
                .build();

        String consultMsg = request.getName()+"님이 Trader "+
                            request.getTrader()+" 에게 컨설팅 문의가 들어왔습니다"
                            +" 전화번호 : "+request.getPhone()+
                            " email : "+ request.getEmail();

        MessageReq messageReq = MessageReq.builder()
                .roomId(0L)
                .user_login_id("admin")
                .messageType(MessageType.TALK)
                .message(consultMsg).build();

        messageService.send(messageReq);

        consultingRepository.save(consulting);

    }

    public List<GetConsultingRes> getAllConsulting(Pageable pageable) {
        List<GetConsultingRes> result = new ArrayList<>();

        Page<Consulting> consultingList = consultingRepository.findAll(pageable);

        consultingList.forEach(
                c -> {
                    result.add(GetConsultingRes.builder()
                            .id(c.getId())
                            .name(c.getName())
                            .phone(c.getPhone())
                            .email(c.getEmail())
                            .context(c.getContext())
                            .replied(c.isReplied())
                            .password(c.getPassword())
                            .trader(c.getTrader())
                            .datetime(c.getUpdatedAt().format(DateTimeFormatter.ofPattern("yy-MM-dd"))).build());
                }
        );

        return result;
    }

    @Transactional
    public void consultReply(WriteConsultingReplyReq writeConsultingReplyReq){
        System.out.println(writeConsultingReplyReq +"asdf");
        Consulting consulting = consultingRepository.findById(writeConsultingReplyReq.getConsulting_id()).get();
        User writer = userRepository.findById(writeConsultingReplyReq.getUser_id()).get();

        consulting.setReplied(true);

        ConsultingReply consultingReply = ConsultingReply.builder()
                .consulting(consulting)
                .user(writer)
                .content(writeConsultingReplyReq.getContent()).build();

        consultingReplyRepository.save(consultingReply);
        consultingRepository.save(consulting);
    }


    public List<GetConsultingReplyRes> getAllConsultingReplyByConsultingId(Long consulting_id) {
        List<GetConsultingReplyRes> result = new ArrayList<>();

        Optional<List<ConsultingReply>> consultingReplyList = consultingReplyRepository.findAllByConsultingId(consulting_id);

        if (consultingReplyList.isPresent()) {
            consultingReplyList.get().forEach(
                    consultingReply -> {
                        result.add(
                                GetConsultingReplyRes.builder()
                                        .id(consultingReply.getId())
                                        .consulting_id(consultingReply.getConsulting().getId())
                                        .writer_id(consultingReply.getUser().getId())
                                        .writer_name(consultingReply.getUser().getName())
                                        .content(consultingReply.getContent())
                                        .build()
                        );
                    }
            );
        }

        return result;
    }

    public GetConsultingRes getConsulting(Long id) {
        Consulting consulting = consultingRepository.findById(id).get();

        return GetConsultingRes.builder()
                .id(consulting.getId())
                .replied(consulting.isReplied())
                .name(consulting.getName())
                .context(consulting.getContext())
                .email(consulting.getEmail())
                .phone(consulting.getPhone())
                .trader(consulting.getTrader())
                .password(consulting.getPassword())
                .datetime(consulting.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build();
    }

    @Modifying
    public void deleteConsulting(Long consultingId) {
        Consulting consulting = consultingRepository.findById(consultingId).get();

        consultingRepository.delete(consulting);
    }

}
