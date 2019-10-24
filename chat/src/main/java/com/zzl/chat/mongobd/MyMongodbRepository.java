package com.zzl.chat.mongobd;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author john（coder_john@163.com）
 * @desc MongoDB持久化类
 * @date 2019-07-22
 */
public interface MyMongodbRepository extends MongoRepository<Book, ObjectId> {



}
