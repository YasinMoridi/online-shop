package com.yasinmoridi.onlineshop.ui.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.yasinmoridi.onlineshop.util.byLocate

@Composable
fun PagerInfoProduct(
    pagerState: PagerState,
    tabNames:List<String>
) {

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.Top,
        key = { tabNames[it] },
        pageSpacing = 12.dp
    ) { page ->
        when (page) {
            0 -> DescriptionSection()
            1 -> FeatureSection()
            2 -> CommentsSection()
            3 -> SimilarProductsSection()
            else -> CommentsSection()
        }
    }

}


@Composable
private fun DescriptionSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "توضیحات",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )
        Text(
            text = "این لباس با استفاده از بهترین متریال تهیه شده و طراحی آن مناسب استفاده روزمره و مجالس نیمه\u200Cرسمی است. ترکیب رنگی جذاب و دوخت دقیق، جلوه\u200Cای خاص به آن بخشیده است. پارچه نرم و تنفس\u200Cپذیر آن باعث راحتی بیشتر در طول روز می\u200Cشود. همچنین فرم استاندارد آن با انواع اندام\u200Cها هماهنگی دارد. اگر به دنبال لباسی شیک، ساده و با کیفیت هستید، این محصول گزینه\u200Cای عالی برای شماست.\n\n\n\n\n\n",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
        )

    }

}

@Composable
private fun FeatureSection() {
    val productFeatures = listOf(
        "جنس: نخ پنبه با کیفیت بالا",
        "وزن خالص: ۵۵۰ گرم",
        "مناسب فصل: بهار و تابستان",
        "قابل شست‌وشو با ماشین لباسشویی",
        "موجود در سایزهای ۳۶ تا ۴۴",
        "دارای تن‌خور راحت و آزاد",
        "رنگ‌بندی متنوع و جذاب",
        "مناسب استفاده روزمره و نیمه‌رسمی"
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "ویژگی ها",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )
        productFeatures.forEach {
            Text(
                text = "• $it",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }

    }

}

@Composable
private fun CommentsSection() {
    data class FakeComment(
        val name: String,
        val rating: Double,
        val comment: String
    )

    val fakeComments = listOf(
        FakeComment("سعیده زینلی", 4.5, "محصول خیلی خوبی بود، ممنون."),
        FakeComment("محمدرضا نادری", 2.5, "کیفیت پایین‌تر از انتظار بود."),
        FakeComment("مینا احمدی", 3.5, "بد نبود ولی می‌شد بهتر باشه."),
        FakeComment("حسین کریمی", 5.5, "عالی و فراتر از انتظار."),
        FakeComment("نگار سلیمانی", 4.5, "طراحی زیبا و عملکرد خوب.")
    )
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "نظرات کاربران",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )
        repeat(fakeComments.size) { index ->
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = fakeComments[index].name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = fakeComments[index].rating.toString().byLocate(),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                        )
                        Spacer(Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Rounded.Star,
                            contentDescription = "",
                            tint = Color(0xffFFC700),
                        )

                    }
                }
                Text(
                    text = fakeComments[index].comment,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
            }

        }
    }

}

@Composable
private fun SimilarProductsSection() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "محصولات مشابه",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )
        Text(
            text = "🥲 محصول مشابهی در حال حاضر موجود نیست، به‌زودی اگر موجود شد خبرتون می‌کنیم!\n\n\n\n\n\n\n\n\n\n",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center
        )


    }

}
