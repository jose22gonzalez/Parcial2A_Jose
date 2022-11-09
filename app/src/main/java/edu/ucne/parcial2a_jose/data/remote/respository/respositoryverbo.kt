package edu.ucne.parcial2a_jose.data.remote.respository

import edu.ucne.parcial2a_jose.data.remote.apiverbo
import edu.ucne.parcial2a_jose.data.remote.dto.VerboDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class respositoryverbo @Inject constructor(
    private val apiverbo: apiverbo
){
    suspend fun GetVerbos(): List<VerboDTO> {
        try {
            val verbo = apiverbo.Getverbos()
            return  verbo
        }catch (e: Exception){
            throw e
        }

    }
}