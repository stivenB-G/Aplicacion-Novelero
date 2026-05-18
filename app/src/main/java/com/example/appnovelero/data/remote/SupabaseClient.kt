package com.example.appnovelero.data.remote

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage

object SupabaseClient {

    private const val SUPABASE_URL = "https://myvicoxukjnqdxakcpmg.supabase.co"
    private const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im15dmljb3h1a2pucWR4YWtjcG1nIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NzkwNDEzNDcsImV4cCI6MjA5NDYxNzM0N30.NSGI93DoONEGlm649Mi7SRWJinSKuPQkMzMT20YQtsY"

    val client = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ) {
        install(Postgrest)
        install(Auth)
        install(Storage)
    }
}
