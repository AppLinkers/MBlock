package com.example.MBlock.repository;

import com.example.MBlock.domain.ConsultingReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultingReplyRepository extends JpaRepository<ConsultingReply, Long> {

    @Query(value = "SELECT c FROM ConsultingReply c WHERE c.user.id = :consulting_id")
    Optional<List<ConsultingReply>> findAllByConsultingId(Long consulting_id);

    Optional<ConsultingReply> findTopByConsultingId(Long consulting_id);
}