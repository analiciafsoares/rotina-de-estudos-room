package com.kw.rotinadeestudoscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kw.rotinadeestudoscompose.data.RotinaDatabase
import com.kw.rotinadeestudoscompose.data.RotinaRepository
import com.kw.rotinadeestudoscompose.ui.theme.RotinaDeEstudosComposeTheme
import com.kw.rotinadeestudoscompose.viewmodel.RotinaViewModel
import com.kw.rotinadeestudoscompose.viewmodel.RotinaViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cria o banco, o repository e a ViewModel
        val db = RotinaDatabase.getDatabase(this)
        val repo = RotinaRepository(db.atividadeDao())
        val factory = RotinaViewModelFactory(repo)
        val viewModel = ViewModelProvider(this, factory)[RotinaViewModel::class.java]

        setContent {
            RotinaDeEstudosComposeTheme {
                RotinaApp(viewModel)
            }
        }
    }
}

@Composable
fun RotinaApp(viewModel: RotinaViewModel) { //Define a navegação entre telas usando Navigation Compose (NavHost / composable)
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            // lista de dias da semana.
            MainScreen { dia ->
                navController.navigate("dia/$dia")
            }
        }

        composable("dia/{dia}") {
            // para ver/adicionar/editar/deletar atividades de um dia específico
            DiaScreen(
                dia = it.arguments?.getString("dia") ?: "",
                viewModel = viewModel,
                onResumoClick = { navController.navigate("resumo") },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("resumo") {
            // mostra um resumo de quantas atividades há por dia e total da semana
            ResumoScreen(viewModel) {
                navController.popBackStack()
            }
        }
    }
}

