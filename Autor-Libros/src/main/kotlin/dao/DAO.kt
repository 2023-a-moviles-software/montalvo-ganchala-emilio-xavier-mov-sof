package dao

abstract class DAO<T> {

    abstract fun delete(id: String): Unit
    abstract fun add(t:T):Unit
    abstract fun edit(t:T):Unit
    abstract fun get(id: String):T?
    abstract fun getLista(): List<T>?



}