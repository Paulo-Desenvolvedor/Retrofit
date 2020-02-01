package com.example.myapplication

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.io.Serializable


class DBConnection:Serializable {

    private  val Host:String
        get() {
            TODO()
        }
    private  val Porta:String
        get() {
            TODO()
        }
    private val BD:String
        get() {
            TODO()
        }
    private val User:String
        get() {
            TODO()
        }
    private val PassWord:String
        get() {
            TODO()
        }
    fun DBConnection(){
        this.Host = "127.0.0.1"

    }
}