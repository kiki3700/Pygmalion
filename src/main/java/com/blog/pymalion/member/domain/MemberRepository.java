package com.blog.pymalion.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// TODO 공부해야함
@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
}
