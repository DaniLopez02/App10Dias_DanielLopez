package com.example.app10dias

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app10dias.Model.Compositor
import com.example.app10dias.DataSource.CompositorDataSource
import com.example.app10dias.ui.theme.App10DiasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App10DiasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}
//COMPOSITORES CLASICOS EUROPEOS
/*
Johann Sebastian Bach (1685-1750) - Barroco
Wolfgang Amadeus Mozart (1756-1791) - Clásico
Ludwig van Beethoven (1770-1827) - Clásico/Romántico
Serguéi Vasílievich Rachmáninov (1873-1943) - Postromántico
Pyotr Ilyich Tchaikovsky (1840-1893) - Romántico
Johannes Brahms (1833-1897) - Romántico
Frederic Chopin (1810-1849) - Romántico
Franz Joseph Haydn (1732-1809) - Clásico
Claude Debussy (1862-1918) - Impresionista
Erik Satie (1866-1925) - Impresionista
 */


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.clavesoldorada),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    text = "Compositores",
                    //style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,

                )
                Spacer(Modifier.width(10.dp))
                Image(
                    painter = painterResource(R.drawable.clavefaddddd),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )

            }
        }
    )
}

//PEVIEW DE LA TARJETA DONDE SE MOSTRARAN LOS COMPOSITORES
@Composable
fun CompositorItem(
    Compositor: Compositor,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
        else MaterialTheme.colorScheme.primaryContainer,
    )
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioHighBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )


        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally){
                Image(
                    painter = painterResource(Compositor.fotografia),
                    contentDescription = null,
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Text(
                    text = stringResource(Compositor.año),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.padding(top = 5.dp),

                )
            }
            Spacer(Modifier.width(10.dp))
            Column(modifier = Modifier.weight(1f)
                ) {
                Text(
                    text = stringResource(Compositor.nombre),
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(Modifier.height(10.dp))
                Row(modifier = Modifier) {
                    Text(
                        text = stringResource(Compositor.estilo),
                        style = MaterialTheme.typography.displayLarge,
                    )
                    Spacer(Modifier.width(10.dp))
                    CompositorButtom(expanded = expanded,
                        onClick = { expanded = !expanded })
                }

                Spacer(Modifier.height(10.dp))
                Text(
                    text = stringResource(Compositor.frase),
                    style = MaterialTheme.typography.displayMedium
                )

                if (expanded) {
                    Spacer(Modifier.height(20.dp))
                    CompositorEnlace(stringResource(Compositor.enlace))
                }
            }
        }
    }
}

@Composable
private fun CompositorButtom(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){

    IconButton(
        onClick = onClick,
        modifier = modifier.size(20.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.PlayArrow,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompositoesApp() {
    var expanded by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopBar()
        }

    ) { it ->
        LazyColumn(contentPadding = it) {
            items(CompositorDataSource.Compositor) {
                CompositorItem(
                    Compositor = it,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun CompositorEnlace(
    enlace : String
){
    val localUriHandler = LocalUriHandler.current
    Column(

    ) {
        Text(
            text = stringResource(id = R.string.fraseEnlace),
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(Modifier.height(10.dp))
        Row {
            ClickableText(
                text = AnnotatedString("PULSA AQUÍ:)"),
                onClick = {
                    localUriHandler.openUri(enlace)
                })
            Icon(
                imageVector = Icons.Filled.Send,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )

        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App10DiasTheme {
        CompositoesApp()
    }
}


