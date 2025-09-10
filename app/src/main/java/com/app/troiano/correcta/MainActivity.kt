package com.app.troiano.correcta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.troiano.correcta.ui.theme.components.BotonPrincipalApp
import com.app.troiano.correcta.ui.theme.components.TituloPrincipal
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.app.troiano.correcta.R
import com.app.troiano.correcta.ui.theme.components.SubtituloApp
import com.app.troiano.correcta.ui.theme.components.TextoLocalizado


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val primary = Color(0xFF1E3EB3)
            MaterialTheme(colorScheme = lightColorScheme(primary = primary)) {
                val nav = rememberNavController()
                AppNavHost(nav, primary)
            }
        }
    }
}

private object Routes {
    const val Welcome = "welcome"
    const val Login = "login"
    const val Register = "register"
}

@Composable
private fun AppNavHost(nav: NavHostController, primary: Color) {
    NavHost(navController = nav, startDestination = Routes.Welcome) {
        composable(Routes.Welcome) {
            WelcomeScreen(
                primary = primary,
                onLogin = { nav.navigate(Routes.Login) },
                onRegister = { nav.navigate(Routes.Register) }
            )
        }
        composable(Routes.Login)    { LoginScreen(primary = primary, onBack = { nav.popBackStack() }) }
        composable(Routes.Register) { RegisterScreen(primary = primary, onBack = { nav.popBackStack() }) }
    }
}

/* 1) WELCOME */
@Composable
fun WelcomeScreen(primary: Color, onLogin: () -> Unit, onRegister: () -> Unit) {
    Surface(Modifier.fillMaxSize(), color = Color.White) {
        Column(
            Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.tipo_sentado_cafe),
                contentDescription = null,
                modifier = Modifier.size(180.dp)
            )
            Spacer(Modifier.height(24.dp))
            //Text("Discover Your", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = primary)
            TituloPrincipal(R.string.welcome_title_discover, color = primary)
            //Text("Dream Job here", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = primary)
            TituloPrincipal(R.string.welcome_title_dream_job, color = primary)
            Spacer(Modifier.height(12.dp))
            SubtituloApp(R.string.welcome_subtitle, color = Color(0xFF333333))
//            Text(
//                "Explore all the existing job roles based on your interest and study major",
//                textAlign = TextAlign.Center,
//                fontSize = 14.sp,
//                color = Color(0xFF333333)
//            )
            Spacer(Modifier.height(24.dp))
            Row(Modifier.fillMaxWidth()) {
                BotonPrincipalApp(
                    texto = "Login",
                    onClick = onLogin,
                    modifier = Modifier.weight(1f), // Aplicamos el weight aquí
                    colorFondo = primary
                )
                Spacer(Modifier.width(16.dp))
                BotonPrincipalApp(
                    texto = "Register",
                    onClick = onRegister,
                    modifier = Modifier.weight(1f), // Aplicamos el weight aquí
                    colorFondo = primary
                )
            }
        }
    }
}

/* 2) LOGIN */
@Composable
fun LoginScreen(primary: Color, onBack: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Surface(Modifier.fillMaxSize(), color = Color.White) {
        Column(
            Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TituloPrincipal(R.string.login_title, color = primary)
            /*Text("Login here", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = primary)*/
            Spacer(Modifier.height(8.dp))
            TextoLocalizado(R.string.login_subtitle)
            /*Text("Welcome back, you have been missed!", textAlign = TextAlign.Center)*/
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = email, onValueChange = { email = it },
                label = { Text("Email") }, singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = pass, onValueChange = { pass = it },
                label = { Text("Password") }, singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(8.dp))
            TextButton(onClick = { }) { Text("Forgot your password?") }
            Spacer(Modifier.height(8.dp))
            BotonPrincipalApp(texto = "Sign in", onClick = { /* login */ }, modifier = Modifier.fillMaxWidth(), colorFondo = primary)
           /* Button(
                onClick = { *//* login *//* },
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primary)
            ) { Text("Sign in") }*/
            Spacer(Modifier.height(8.dp))
            TextButton(onClick = onBack) { Text("Back") }
        }
    }
}

/* 3) REGISTER */
@Composable
fun RegisterScreen(primary: Color, onBack: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var confirm by remember { mutableStateOf("") }

    Surface(Modifier.fillMaxSize(), color = Color.White) {
        Column(
            Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TituloPrincipal(R.string.register_title, color = primary)
            /*Text("Create Account", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = primary)*/
            Spacer(Modifier.height(8.dp))
            TextoLocalizado(R.string.register_subtitle)
            /*Text("Create an account so you can explore all the existing jobs", textAlign = TextAlign.Center)*/
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                value = email, onValueChange = { email = it },
                label = { Text("Email") }, singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = pass, onValueChange = { pass = it },
                label = { Text("Password") }, singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = confirm, onValueChange = { confirm = it },
                label = { Text("Confirm Password") }, singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(12.dp))
            BotonPrincipalApp(texto = "Sign up", onClick = { /* registro */ }, modifier = Modifier.fillMaxWidth(), colorFondo = primary)
            /*Button(
                onClick = { *//* registro *//* },
                modifier = Modifier.fillMaxWidth().height(48.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primary)
            ) { Text("Sign up") }*/
            Spacer(Modifier.height(8.dp))
            TextButton(onClick = onBack) { Text("Back") }
        }
    }
}
