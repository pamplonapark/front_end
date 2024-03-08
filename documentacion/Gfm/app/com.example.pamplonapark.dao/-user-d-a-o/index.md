//[app](../../../index.md)/[com.example.pamplonapark.dao](../index.md)/[UserDAO](index.md)

# UserDAO

[androidJvm]\
interface [UserDAO](index.md)

Data Access Object (DAO) for the user entity. This DAO provides methods to perform CRUD (Create, Read, Update, Delete) operations on the user table in the database.

## Functions

| Name | Summary |
|---|---|
| [delete](delete.md) | [androidJvm]<br>abstract fun [delete](delete.md)(user: [User](../../com.example.pamplonapark.dataModels/-user/index.md))<br>Deletes a user from the database. |
| [getUserByUsername](get-user-by-username.md) | [androidJvm]<br>abstract fun [getUserByUsername](get-user-by-username.md)(username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [User](../../com.example.pamplonapark.dataModels/-user/index.md)?<br>Gets a user by their username. |
| [insert](insert.md) | [androidJvm]<br>abstract fun [insert](insert.md)(user: [User](../../com.example.pamplonapark.dataModels/-user/index.md))<br>Inserts a new user into the database. |
| [update](update.md) | [androidJvm]<br>abstract fun [update](update.md)(user: [User](../../com.example.pamplonapark.dataModels/-user/index.md))<br>Updates an existing user in the database. |
