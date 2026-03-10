package com.misw4302ux9.sistemamedicamentos.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlarmAdd
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.ui.components.AppButton
import com.misw4302ux9.sistemamedicamentos.ui.components.AppCheckboxListItem
import com.misw4302ux9.sistemamedicamentos.ui.components.AppDatePickerField
import com.misw4302ux9.sistemamedicamentos.ui.components.AppDropdownField
import com.misw4302ux9.sistemamedicamentos.ui.components.AppNumericField
import com.misw4302ux9.sistemamedicamentos.ui.components.AppSearchField
import com.misw4302ux9.sistemamedicamentos.ui.components.AppTabs
import com.misw4302ux9.sistemamedicamentos.ui.components.AppTimePickerField
import com.misw4302ux9.sistemamedicamentos.ui.components.AppTopBar
import com.misw4302ux9.sistemamedicamentos.ui.components.ScreenBackground
import com.misw4302ux9.sistemamedicamentos.ui.theme.AcentoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.White
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrearAlarmaScreen(
    onBackClick: () -> Unit,
    onNavigateToHistorial: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    var medicamento by remember { mutableStateOf("") }
    var fechaInicio by remember { mutableStateOf("28 Feb 2026") }
    var horaInicio by remember { mutableStateOf("8:00 PM") }
    var frecuencia by remember { mutableStateOf("Días") }
    var unidad by remember { mutableIntStateOf(1) }
    var posponerDosVeces by remember { mutableStateOf(true) }
    var posponerIndefinida by remember { mutableStateOf(true) }

    // Estado para el DatePicker
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    // Estado para el TimePicker
    var showTimePicker by remember { mutableStateOf(false) }
    val timePickerState = rememberTimePickerState(
        initialHour = 20,
        initialMinute = 0,
        is24Hour = false
    )

    val medicamentosSugeridos = listOf("Ibuprofeno", "Magnesio", "Enalapril", "Atorvastatina")

    // Diálogo de DatePicker con colores personalizados
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let { millis ->
                        val date = Date(millis)
                        val formatter = SimpleDateFormat("dd MMM yyyy", Locale("es", "ES"))
                        fechaInicio = formatter.format(date)
                    }
                    showDatePicker = false
                }) {
                    Text("Aceptar", color = PrimarioBase)
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancelar", color = PrimarioBase)
                }
            },
            colors = DatePickerDefaults.colors(
                containerColor = White
            )
        ) {
            DatePicker(
                state = datePickerState,
                colors = DatePickerDefaults.colors(
                    titleContentColor = TextosBase,
                    headlineContentColor = TextosBase,
                    weekdayContentColor = TextosBase,
                    subheadContentColor = TextosBase,
                    yearContentColor = TextosBase,
                    currentYearContentColor = PrimarioBase,
                    selectedYearContentColor = White,
                    selectedYearContainerColor = PrimarioBase,
                    dayContentColor = TextosBase,
                    selectedDayContainerColor = AcentoBase,
                    selectedDayContentColor = White,
                    todayContentColor = PrimarioBase,
                    todayDateBorderColor = PrimarioBase
                )
            )
        }
    }

    // Diálogo de TimePicker con colores personalizados
    if (showTimePicker) {
        AlertDialog(
            onDismissRequest = { showTimePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    val cal = Calendar.getInstance()
                    cal.set(Calendar.HOUR_OF_DAY, timePickerState.hour)
                    cal.set(Calendar.MINUTE, timePickerState.minute)
                    val formatter = SimpleDateFormat("h:mm a", Locale.US)
                    horaInicio = formatter.format(cal.time)
                    showTimePicker = false
                }) {
                    Text("Aceptar", color = PrimarioBase)
                }
            },
            dismissButton = {
                TextButton(onClick = { showTimePicker = false }) {
                    Text("Cancelar", color = PrimarioBase)
                }
            },
            text = {
                TimePicker(
                    state = timePickerState,
                    colors = TimePickerDefaults.colors(
                        clockDialColor = White,
                        clockDialSelectedContentColor = White,
                        clockDialUnselectedContentColor = TextosBase,
                        selectorColor = AcentoBase,
                        periodSelectorBorderColor = PrimarioBase,
                        periodSelectorSelectedContainerColor = AcentoBase,
                        periodSelectorUnselectedContainerColor = White,
                        periodSelectorSelectedContentColor = White,
                        periodSelectorUnselectedContentColor = PrimarioBase,
                        timeSelectorSelectedContainerColor = AcentoBase,
                        timeSelectorUnselectedContainerColor = White,
                        timeSelectorSelectedContentColor = White,
                        timeSelectorUnselectedContentColor = PrimarioBase
                    )
                )
            },
            containerColor = White
        )
    }

    ScreenBackground {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start
            ) {
                // Barra superior
                AppTopBar(
                    title = "Alejandra (Tu perfil)",
                    onBackClick = onBackClick
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Pestañas
                AppTabs(
                    selectedTabIndex = selectedTabIndex,
                    onTabSelected = { index ->
                        if (index == 1) {
                            onNavigateToHistorial()
                        } else {
                            selectedTabIndex = index
                        }
                    }
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Título de la sección
                Text(
                    text = "Crear una nueva alarma",
                    style = MaterialTheme.typography.displaySmall,
                    color = TextosBase,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Campo Medicamento
                AppSearchField(
                    value = medicamento,
                    onValueChange = { medicamento = it },
                    label = "Medicamento",
                    suggestions = medicamentosSugeridos,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Fila Fecha y Hora
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    AppDatePickerField(
                        value = fechaInicio,
                        onClick = { showDatePicker = true }, // Abrir el diálogo real
                        label = "Fecha Inicio",
                        modifier = Modifier.weight(1.6f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AppTimePickerField(
                        value = horaInicio,
                        onClick = { showTimePicker = true }, // Abrir el diálogo real
                        label = "Hora Inicio",
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Fila Frecuencia y Unidad
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    AppDropdownField(
                        value = frecuencia,
                        onValueChange = { frecuencia = it },
                        label = "Frecuencia",
                        options = listOf("Minutos", "Horas", "Días", "Semanas"),
                        modifier = Modifier.weight(1.6f)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    AppNumericField(
                        value = unidad,
                        onValueChange = { unidad = it },
                        label = "Unidad",
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Opciones de posponer
                AppCheckboxListItem(
                    text = "Posponer alarma hasta dos veces por 5 minutos",
                    checked = posponerDosVeces,
                    onCheckedChange = { posponerDosVeces = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                AppCheckboxListItem(
                    text = "Posponer alarma indefinida, cada vez sonará mas fuerte hasta confirmar toma",
                    checked = posponerIndefinida,
                    onCheckedChange = { posponerIndefinida = it }
                )

                Spacer(modifier = Modifier.height(80.dp)) // Espacio para el botón de abajo
            }

            // Botón Agregar posicionado abajo a la derecha
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(24.dp)
            ) {
                AppButton(
                    text = "Agregar",
                    icon = Icons.Default.AlarmAdd,
                    onClick = onBackClick,
                    modifier = Modifier.width(160.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec:width=412dp,height=917dp")
@Composable
fun CrearAlarmaScreenPreview() {
    SistemaMedicamentosTheme {
        CrearAlarmaScreen(onBackClick = {}, onNavigateToHistorial = {})
    }
}