package com.example.taskappbar

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
    Scaffold(
        topBar = {
                TopAppBar( content = { Text(text = "TaskAppBar")}
                )
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
                    taskName = "Tarefa 1",
                taskDetails = "É bem melhor usar lazilist ao inves de colum")
            Text(text = "Task1")
            Text(text = "Task2")
            Text(text = "Task3")
            Text(text = "Task4")
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
    taskName: String
    taskDetails: String,
    deadEndDate: Date
   ) {
    val dateFormatter = SimpleDateFormat("EEE, MMM dd, YYYY", locale.getDefault())
    Row(modifier = modificador) {
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Icons of a pendent task"
        )
    }
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
}// Fun minha tarefaX "MyTaskWidget"


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreenContent()
}