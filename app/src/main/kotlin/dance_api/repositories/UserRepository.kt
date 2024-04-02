package dance_api.repositories

import dance_api.models.UserModel

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserModel, Long>
