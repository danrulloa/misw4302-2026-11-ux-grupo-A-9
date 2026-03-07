package com.misw4302ux9.sistemamedicamentos.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.misw4302ux9.sistemamedicamentos.ui.theme.FondoBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.PrimarioBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.SistemaMedicamentosTheme
import com.misw4302ux9.sistemamedicamentos.ui.theme.TextosBase
import com.misw4302ux9.sistemamedicamentos.ui.theme.White

@Composable
fun AppSwitchListItem(
    headline: String,
    supportingText: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(72.dp),
        color = Color.White,
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Textos (Headline y Supporting text)
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = headline,
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextosBase
                )
                Text(
                    text = supportingText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = TextosBase.copy(alpha = 0.7f)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Switch
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = PrimarioBase,
                    checkedTrackColor = White,
                    checkedBorderColor = PrimarioBase,
                    uncheckedThumbColor = Color.Gray.copy(alpha = 0.5f),
                    uncheckedTrackColor = White,
                    uncheckedBorderColor = Color.Gray.copy(alpha = 0.5f)
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppSwitchListItemPreview() {
    SistemaMedicamentosTheme {
        Column(modifier = Modifier.background(FondoBase).padding(vertical = 16.dp)) {
            AppSwitchListItem(
                headline = "Magnesio",
                supportingText = "8:00 PM (Cada día)",
                checked = true,
                onCheckedChange = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            AppSwitchListItem(
                headline = "Vitamina C",
                supportingText = "9:00 AM (Cada día)",
                checked = false,
                onCheckedChange = {}
            )
        }
    }
}
