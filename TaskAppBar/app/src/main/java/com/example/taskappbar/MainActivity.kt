package com.example.taskappbar

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskappbar.ui.theme.TaskAppBarTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenContent()
        }
    }
}

@Composable
fun MainScreenContent() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState( drawerState = drawerState)
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
                TopAppBar(
                    title = { Text(text = "TaskTodayApp")},
                    navigationIcon = {
                        IconButton(onClick = {
                            CoroutineScope(Dispatchers.Default).launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                        ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Drawer Menu")
                    }
                 }
             )
    },
        drawerBackgroundColor = Color.Red,
        drawerGesturesEnabled = drawerState.isOpen,
        drawerContent = {
            //Drawer header
            Box(
                modifier = Modifier
                    .background(Color.Magenta)
                    .height(16.dp)
            ) {
                Text(text = "Opções!!!")
            }
            //Drawer content
            Column() {
                Text(text = "Opcao de menu 1")
                Text(text = "Opcao de menu 2")
                Text(text = "Opcao de menu 3")
            }
        },

        content = {
                paddingValues -> Log.i("paddingValues", "$paddingValues")
            Column(
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxSize()
        ) {
                MySearchField(modificador = Modifier.fillMaxWidth())
                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth(),
                    taskName = "Preparar aula Lazylist / Lazy/column",
                    taskDetails = "É bem melhor usar lazilist ao inves de colum",
                    deadEndDate = Date()
                  )
                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth(),
                    taskName = "Prova Matematica",
                    taskDetails = "Estudar Calculo capitulo 1 e 2",
                    deadEndDate = Date()
                )
           }
        },
        bottomBar = {
            BottomAppBar(
                content = { Text("assdfg")}
            )
        },
    )//fechando Scaffold
}// fun MainScreenContent()

@Composable
fun MySearchField(modificador: Modifier){
    TextField(value = "",
        onValueChange = {},
        modifier = modificador,
        placeholder = { Text(text = "Pesquisar Tarefas")},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = "Search Icon" )
        }
    )
}// Fun Campo de pesquisa "MySearchField"


@Composable
fun MyTaskWidget(
    modificador: Modifier,
    taskName: String,
    taskDetails: String,
    deadEndDate: Date
   ) {
    val dateFormatter = SimpleDateFormat("EEE, MMM dd, YYYY", Locale.getDefault())
    Row(modifier = modificador) {
        Column(){
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Icons of a pendent task"
        )
            Text(
                text = dateFormatter.format(deadEndDate),
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 12.sp
            )
    }//coluna icone e data // abaixo columa do taskname e task details
    Column(
        modifier = modificador
            .border(width = 1.dp, color = Color.Black)
            .padding(3.dp)
    ) {
        Text(
            text = taskName,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = taskDetails,
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
    }//coluna/Column
  }//Row(modifier = modificador)
    Spacer(modifier = Modifier.height(16.dp))
}// Fun minha tarefaX "MyTaskWidget"


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreenContent()
}
