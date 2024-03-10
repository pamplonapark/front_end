//[app](../../../index.md)/[com.example.pamplonapark.database](../index.md)/[DatabaseManager](index.md)

# DatabaseManager

abstract class [DatabaseManager](index.md) : [RoomDatabase](https://developer.android.com/reference/kotlin/androidx/room/RoomDatabase.html)

Class acting as the main database for the PamplonaPark application. This class is responsible for providing a singleton instance of the database and contains an abstract method to access the user DAO.

#### Parameters

androidJvm

| | |
|---|---|
| entities | Array of entity classes representing the database tables. |
| version | Database version. |

## Constructors

| | |
|---|---|
| [DatabaseManager](-database-manager.md) | [androidJvm]<br>constructor() |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [userDao](user-dao.md) | [androidJvm]<br>abstract fun [userDao](user-dao.md)(): [UserDAO](../../com.example.pamplonapark.dao/-user-d-a-o/index.md)<br>Abstract method to access the user DAO. |
