package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.AttendanceStatus
import com.example.data.model.BehaviorType
import com.example.ui.theme.BoyAvatarBg
import com.example.ui.theme.BoyAvatarText
import com.example.ui.theme.ErrorRed
import com.example.ui.theme.ErrorRedContainer
import com.example.ui.theme.GirlAvatarBg
import com.example.ui.theme.GirlAvatarText
import com.example.ui.theme.InfoBlue
import com.example.ui.theme.InfoBlueContainer
import com.example.ui.theme.SchoolPrimary
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SuccessGreenContainer
import com.example.ui.theme.WarningAmber
import com.example.ui.theme.WarningAmberContainer
import com.example.util.ZaloShareHelper

@Composable
fun StudentAvatar(
    stt: Int,
    gender: String,
    modifier: Modifier = Modifier,
    size: Int = 44
) {
    val isBoy = gender.equals("Nam", ignoreCase = true)
    val bgColor = if (isBoy) BoyAvatarBg else GirlAvatarBg
    val textColor = if (isBoy) BoyAvatarText else GirlAvatarText

    Box(
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(bgColor),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$stt",
                color = textColor,
                fontWeight = FontWeight.Bold,
                fontSize = (size / 3.2).sp
            )
            Icon(
                imageVector = if (isBoy) Icons.Default.Male else Icons.Default.Female,
                contentDescription = gender,
                tint = textColor.copy(alpha = 0.85f),
                modifier = Modifier.size((size / 3.5).dp)
            )
        }
    }
}

@Composable
fun AttendanceBadge(status: AttendanceStatus, modifier: Modifier = Modifier) {
    val (bgColor, textColor) = when (status) {
        AttendanceStatus.DI_HOC -> SuccessGreenContainer to SuccessGreen
        AttendanceStatus.DI_TRE -> WarningAmberContainer to WarningAmber
        AttendanceStatus.NGHI_CO_PHEP -> InfoBlueContainer to InfoBlue
        AttendanceStatus.NGHI_KHONG_PHEP -> ErrorRedContainer to ErrorRed
    }

    Surface(
        color = bgColor,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        Text(
            text = status.label,
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
        )
    }
}

@Composable
fun BehaviorBadge(type: BehaviorType, category: String, modifier: Modifier = Modifier) {
    val (bgColor, textColor) = if (type == BehaviorType.PRAISE) {
        SuccessGreenContainer to SuccessGreen
    } else {
        ErrorRedContainer to ErrorRed
    }

    Surface(
        color = bgColor,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Text(
            text = category,
            color = textColor,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.dp)
        )
    }
}

@Composable
fun MessagePreviewDialog(
    recipientName: String,
    recipientPhone: String,
    message: String,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Chat,
                    contentDescription = null,
                    tint = SchoolPrimary,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Gửi Tin Nhắn Zalo Phụ Huynh",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                    Text(
                        text = "Người nhận: $recipientName ($recipientPhone)",
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    text = "Nội dung tin nhắn chuẩn bị gửi:",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = message,
                        fontSize = 12.sp,
                        lineHeight = 18.sp,
                        modifier = Modifier.padding(12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "💡 Khi bấm 'Mở Zalo', hệ thống sẽ tự động sao chép tin nhắn và mở Zalo số $recipientPhone để thầy/cô dán gửi ngay.",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    ZaloShareHelper.openZaloChat(context, recipientPhone, message)
                    onDismiss()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0068FF)),
                modifier = Modifier.testTag("open_zalo_button")
            ) {
                Icon(imageVector = Icons.Default.Chat, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("Mở Zalo", fontWeight = FontWeight.Bold)
            }
        },
        dismissButton = {
            Row {
                OutlinedButton(
                    onClick = {
                        ZaloShareHelper.copyToClipboard(context, message)
                    },
                    modifier = Modifier.testTag("copy_message_button")
                ) {
                    Icon(imageVector = Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Sao chép", fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.width(6.dp))
                OutlinedButton(
                    onClick = {
                        ZaloShareHelper.shareMessage(context, message)
                        onDismiss()
                    },
                    modifier = Modifier.testTag("share_message_button")
                ) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Chia sẻ", fontSize = 12.sp)
                }
            }
        }
    )
}
