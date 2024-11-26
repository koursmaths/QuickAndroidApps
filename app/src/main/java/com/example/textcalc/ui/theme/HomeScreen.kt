package com.example.textcalc.ui.theme

import android.graphics.Paint.Align
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.textcalc.Convert2Numer
import com.example.textcalc.lDit
import com.example.textcalc.R
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import java.sql.ResultSet
import javax.xml.transform.Result

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    convert2numer: Convert2Numer = viewModel()
){
    MainScreen(
        inputTx = convert2numer.inputTx,
        getNum = {convert2numer.getNum(it)},
        matchWrd = {convert2numer.matchWrd(it)},
        onValueChange = convert2numer.onValueChange,
        numer =convert2numer.numer,
        ct=convert2numer.ct,
        lnn = convert2numer.lnn
)

}
@Composable
fun MainScreen(
    modifier:Modifier = Modifier,
    inputTx: String,
    getNum: (String) -> Unit,
    matchWrd: (String) -> Unit,
    onValueChange: (String) -> Unit,
    numer: String,
    ct: String,
    lnn: List<String>
){
    val focusRequester = remember{FocusRequester()}
    val focusManager = LocalFocusManager.current
    val lnnArr = stringArrayResource(R.array.Discover_them)
    Column(
        modifier = modifier.padding(30.dp).focusRequester(focusRequester),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(
            stringResource(id = R.string.numerico),
            fontSize = 30.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        EditTxField(
            label = R.string.inputTxt,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {focusManager.clearFocus()}
            ) ,
            value = inputTx,
            onValueChange = onValueChange
        )
        Text(
            text = stringResource(R.string.numero, numer),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedButton(
            modifier = modifier,
            onClick = { getNum(inputTx) }) {
            Text(text = "Numerically")

        }

        Text(
            text = stringResource(R.string.similarly,lnn),
            modifier = Modifier,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal
        )

        OutlinedButton(
            modifier = modifier,
            onClick = {matchWrd(inputTx) }) {
            Text(text = "Similarly")
        }
        Spacer(modifier = (Modifier.height(50.dp)))
        Button(
            modifier = modifier,
            onClick = {focusManager.clearFocus()}) {
            Text("Clear")
        }

    }

}

private fun ColumnScope.Text(
    stringArrayResource: Array<String>,
    modifier: Modifier,
    sp: TextUnit,
    fontWeight: FontWeight
) {
    Text(stringArrayResource = stringArrayResource,
        modifier = Modifier.align(Alignment.CenterHorizontally),
        sp = 0.5.sp,
        fontWeight = fontWeight

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTxField(
    @StringRes label:Int,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(label)) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )
}
