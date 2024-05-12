package kz.vkInternship.pokemon.ui.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import kz.vkInternship.pokemon.ui.theme.MainPageText

@Composable
fun PaginationControl(
    currentPage: Int,
    totalPages: Int,
    onNextClicked: () -> Unit,
    onPreviousClicked: () -> Unit,
    onPageClicked: (page: Int) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (currentPage == totalPages) {
            Text(
                text = "Previous",
                modifier = Modifier.clickable { onPreviousClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "1",
                modifier = Modifier.clickable { onPageClicked(1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = " ... ", color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage - 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage - 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "$currentPage",
                textDecoration = TextDecoration.Underline,
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
        } else if (currentPage == 1) {
            Text(
                text = "$currentPage",
                textDecoration = TextDecoration.Underline,
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage + 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage + 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = "${currentPage + 2}",
                modifier = Modifier.clickable { onPageClicked(currentPage + 2) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = " ... ",
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = totalPages.toString(),
                modifier = Modifier.clickable { onPageClicked(totalPages) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = "Next",
                modifier = Modifier.clickable { onNextClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
        } else if (currentPage == 2) {
            Text(
                text = "Previous",
                modifier = Modifier.clickable { onPreviousClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "1",
                modifier = Modifier.clickable { onPageClicked(1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "$currentPage",
                textDecoration = TextDecoration.Underline,
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage + 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage + 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = "${currentPage + 2}",
                modifier = Modifier.clickable { onPageClicked(currentPage + 2) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = " ... ", color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = totalPages.toString(),
                modifier = Modifier.clickable { onPageClicked(totalPages) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = "Next",
                modifier = Modifier.clickable { onNextClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

        } else if (currentPage == 3) {
            Text(
                text = "Previous",
                modifier = Modifier.clickable { onPreviousClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "1",
                modifier = Modifier.clickable { onPageClicked(1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage - 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage - 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "$currentPage",
                textDecoration = TextDecoration.Underline,
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage + 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage + 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = "${currentPage + 2}",
                modifier = Modifier.clickable { onPageClicked(currentPage + 2) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(text = " ... ")
            Text(
                text = totalPages.toString(),
                modifier = Modifier.clickable { onPageClicked(totalPages) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = "Next",
                modifier = Modifier.clickable { onNextClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
        } else if (currentPage + 1 == totalPages) {
            Text(
                text = "Previous",
                modifier = Modifier.clickable { onPreviousClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "1",
                modifier = Modifier.clickable { onPageClicked(1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = " ... ",
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage - 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage - 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "$currentPage",
                textDecoration = TextDecoration.Underline,
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage + 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage + 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = "Next",
                modifier = Modifier.clickable { onNextClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
        } else if (currentPage + 2 == totalPages) {
            Text(
                text = "Previous",
                modifier = Modifier.clickable { onPreviousClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "1",
                modifier = Modifier.clickable { onPageClicked(1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = " ... ",
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage - 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage - 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "$currentPage",
                textDecoration = TextDecoration.Underline,
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage + 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage + 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = totalPages.toString(),
                modifier = Modifier.clickable { onPageClicked(totalPages) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = "Next",
                modifier = Modifier.clickable { onNextClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
        } else {
            Text(
                text = "Previous",
                modifier = Modifier.clickable { onPreviousClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
                //color = if (currentPage > 1) MainPageText else MainPageText.copy(alpha = 0.3f)
            )
            Text(
                text = "1",
                modifier = Modifier.clickable { onPageClicked(1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = " ... ", color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage - 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage - 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
                //color = if (currentPage > 1) MainPageText else MainPageText.copy(alpha = 0.3f)
            )
            Text(
                text = "$currentPage",
                textDecoration = TextDecoration.Underline,
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = "${currentPage + 1}",
                modifier = Modifier.clickable { onPageClicked(currentPage + 1) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = " ... ",
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = totalPages.toString(),
                modifier = Modifier.clickable { onPageClicked(totalPages) },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )

            Text(
                text = "Next",
                modifier = Modifier.clickable { onNextClicked() },
                color = MainPageText,
                fontFamily = FontFamily.Monospace
            )
        }
    }
}
