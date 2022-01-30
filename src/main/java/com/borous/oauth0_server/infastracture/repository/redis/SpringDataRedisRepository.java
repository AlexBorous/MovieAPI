package com.borous.oauth0_server.infastracture.repository.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SpringDataRedisRepository extends CrudRepository<MovieEntity,String> {
}
