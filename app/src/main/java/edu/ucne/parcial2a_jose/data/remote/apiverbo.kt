package edu.ucne.parcial2a_jose.data.remote

import edu.ucne.parcial2a_jose.data.remote.dto.VerboDTO
import retrofit2.Response
import retrofit2.http.GET

interface apiverbo {

    @GET("api/verbos")
    suspend fun Getverbos(): Response<List<VerboDTO>>
}