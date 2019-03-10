/*
 * Harmonica Demo Application
 * Copyright (C) 2019  Kenji Otsuka
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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