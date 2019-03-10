package com.example.demo.db.migration

import com.improve_future.harmonica.core.AbstractMigration

/**
 * CreateTask
 */
class M20190209141813199_CreateTask : AbstractMigration() {
    override fun up() {
        createTable("task") {
            varchar("name", size = 200, nullable = false)
            dateTime("created_at", nullable = false)
            dateTime("updated_at", nullable = false)
        }
    }

    override fun down() {
        dropTable("task")
    }
}