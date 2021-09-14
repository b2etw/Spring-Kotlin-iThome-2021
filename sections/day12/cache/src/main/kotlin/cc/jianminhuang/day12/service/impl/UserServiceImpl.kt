package cc.jianminhuang.day12.service.impl

import cc.jianminhuang.day12.data.dao.UserDao
import cc.jianminhuang.day12.data.dto.UserDto
import cc.jianminhuang.day12.service.UserService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.redis.core.ReactiveStringRedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val stringRedisTemplate: StringRedisTemplate,
    val userDao: UserDao
): UserService {

    @CachePut(cacheNames = ["UserService"], key = "#result.id")
    override fun addUser(userDto: UserDto) = userDao.save(userDto.toDo()).toDto()

    @Cacheable(cacheNames = ["UserService"], key = "#id")
    override fun queryUserById(id: Long) =
        userDao.findById(id)
            .map {
                stringRedisTemplate.op
                it.toDto()
            }
            .orElseThrow { RuntimeException() }

    @CachePut(cacheNames = ["UserService"], key = "#result.id")
    override fun modifyUser(userDto: UserDto) =
        userDao.findById(userDto.id!!)
            .orElseThrow { RuntimeException() }
            .run {
                this.firstName = userDto.name.split(",")[0].trim()
                this.lastName = userDto.name.split(",")[1].trim()
                this.age = userDto.age
                userDao.save(this).toDto()
            }

    @CacheEvict(cacheNames = ["UserService"], key = "#id")
    override fun removeUserById(id: Long) = userDao.deleteById(id)
}