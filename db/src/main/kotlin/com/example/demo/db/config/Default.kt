package com.example.demo.db

import com.improve_future.harmonica.core.DbConfig
import com.improve_future.harmonica.core.Dbms

class Default : DbConfig({
    dbms = Dbms.PostgreSQL
    dbName = "demo"
    host = "127.0.0.1"
    user = "developer"
    password = "developer"
    // Add port configuration if you need
    // port = 5432
})