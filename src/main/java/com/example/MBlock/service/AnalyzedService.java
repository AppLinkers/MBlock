package com.example.MBlock.service;

import com.example.MBlock.domain.Analyzed;
import com.example.MBlock.dto.analyzed.AnalyzedFindRes;
import com.example.MBlock.dto.analyzed.AnalyzedWriteReq;
import com.example.MBlock.repository.AnalyzedRepository;
import com.example.MBlock.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AnalyzedService {

    private final UserRepository userRepository;
    private final AnalyzedRepository analyzedRepository;

    public Page<AnalyzedFindRes> findAll(int page) {
        PageRequest pageRequest = PageRequest.of(page, 10);
        Page<Analyzed> findAnalyzedList = analyzedRepository.findAll(pageRequest);

        Page<AnalyzedFindRes> result = findAnalyzedList.map(analyzed ->
            new AnalyzedFindRes(analyzed.getId(), analyzed.getTitle(), analyzed.getContext() ,analyzed.getUser_name(), analyzed.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        );

        return result;
    }

    public void write(AnalyzedWriteReq request) {

        String name = userRepository.findUserNameByUser_id(request.getWriter());
        request.setWriter(name);

        Analyzed analyzed = Analyzed.builder()
                .title(request.getTitle())
                .user_name(request.getWriter())
                .context(request.getContent())
                .build();

        if (request.getFile() != null) {
            analyzed.setFile_url("file exist");
        } else {
            analyzed.setFile_url("file null");
        }

        analyzedRepository.save(analyzed);
    }
}
