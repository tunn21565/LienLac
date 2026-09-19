package com.example.data.db

import com.example.data.model.AttendanceRecord
import com.example.data.model.AttendanceStatus
import com.example.data.model.BehaviorLog
import com.example.data.model.BehaviorType
import com.example.data.model.SchoolRequest
import com.example.data.model.SemesterResult
import com.example.data.model.Student
import com.example.data.model.TermType
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object SeedData {
    fun getTodayString(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }

    val students = listOf(
        Student(1, 1, "Nguyễn Bảo Anh", "Nam", "18/12/2016", "0912345001", "Phụ huynh em Bảo Anh"),
        Student(2, 2, "Nguyễn Bách Thiên Ân", "Nam", "25/05/2016", "0912345002", "Phụ huynh em Thiên Ân"),
        Student(3, 3, "Nguyễn Minh Đăng", "Nam", "31/05/2016", "0912345003", "Phụ huynh em Minh Đăng"),
        Student(4, 4, "Nguyễn Quốc Đông", "Nam", "07/10/2016", "0912345004", "Phụ huynh em Quốc Đông"),
        Student(5, 5, "Nguyễn Ngọc Kim Huệ", "Nữ", "16/08/2016", "0912345005", "Phụ huynh em Kim Huệ"),
        Student(6, 6, "Nguyễn Ngọc Huy", "Nam", "12/11/2016", "0912345006", "Phụ huynh em Ngọc Huy"),
        Student(7, 7, "Ngô Thị Mai Huyền", "Nữ", "24/06/2016", "0912345007", "Phụ huynh em Mai Huyền"),
        Student(8, 8, "Nguyễn Chí Khang", "Nam", "03/03/2016", "0912345008", "Phụ huynh em Chí Khang"),
        Student(9, 9, "Bùi Hoàng Đăng Khôi", "Nam", "27/10/2016", "0912345009", "Phụ huynh em Đăng Khôi"),
        Student(10, 10, "Hồ Đăng Khôi", "Nam", "25/05/2016", "0912345010", "Phụ huynh em Đăng Khôi"),
        Student(11, 11, "Lê Trọng Duy Khôi", "Nam", "22/08/2016", "0912345011", "Phụ huynh em Duy Khôi"),
        Student(12, 12, "Nguyễn Đăng Khôi", "Nam", "02/08/2016", "0912345012", "Phụ huynh em Đăng Khôi"),
        Student(13, 13, "Phan Ngọc Thiên Kim", "Nữ", "16/06/2016", "0912345013", "Phụ huynh em Thiên Kim"),
        Student(14, 14, "Trịnh Hoàng Lâm", "Nam", "23/11/2016", "0912345014", "Phụ huynh em Hoàng Lâm"),
        Student(15, 15, "Lê Gia Long", "Nam", "03/11/2016", "0912345015", "Phụ huynh em Gia Long"),
        Student(16, 16, "Phùng Nguyễn Trọng Nghĩa", "Nam", "29/09/2016", "0912345016", "Phụ huynh em Trọng Nghĩa"),
        Student(17, 17, "Phạm Thị Quỳnh Như", "Nữ", "02/03/2016", "0912345017", "Phụ huynh em Quỳnh Như"),
        Student(18, 18, "Phan Phạm Như Quỳnh", "Nữ", "29/11/2016", "0912345018", "Phụ huynh em Như Quỳnh"),
        Student(19, 19, "Nguyễn Thành Sĩ", "Nam", "02/08/2016", "0912345019", "Phụ huynh em Thành Sĩ"),
        Student(20, 20, "Nguyễn Ngọc Đan Thanh", "Nữ", "14/10/2016", "0912345020", "Phụ huynh em Đan Thanh"),
        Student(21, 21, "Lê Hoàng Bảo Thy", "Nữ", "14/05/2015", "0912345021", "Phụ huynh em Bảo Thy"),
        Student(22, 22, "Lê Văn Tình", "Nam", "11/05/2016", "0912345022", "Phụ huynh em Văn Tình"),
        Student(23, 23, "Nguyễn Minh Tiến", "Nam", "2016", "0912345023", "Phụ huynh em Minh Tiến"),
        Student(24, 24, "Huỳnh Thị Ngọc Trâm", "Nữ", "07/06/2016", "0912345024", "Phụ huynh em Ngọc Trâm"),
        Student(25, 25, "Nguyễn Thị Bảo Trân", "Nữ", "13/08/2016", "0912345025", "Phụ huynh em Bảo Trân"),
        Student(26, 26, "Lê Phạm Nhã Trúc", "Nữ", "27/09/2016", "0912345026", "Phụ huynh em Nhã Trúc"),
        Student(27, 27, "Nguyễn Huỳnh Thanh Trúc", "Nữ", "10/07/2016", "0912345027", "Phụ huynh em Thanh Trúc"),
        Student(28, 28, "Trần Kim Trúc", "Nữ", "26/05/2016", "0912345028", "Phụ huynh em Kim Trúc"),
        Student(29, 29, "Nguyễn Thúy Vy", "Nữ", "04/03/2016", "0912345029", "Phụ huynh em Thúy Vy"),
        Student(30, 30, "Phạm Thị Như Ý", "Nữ", "05/10/2016", "0912345030", "Phụ huynh em Như Ý"),
        Student(31, 31, "Võ Ngọc Như Ý", "Nữ", "10/11/2016", "0912345031", "Phụ huynh em Như Ý")
    )

    fun createInitialAttendance(date: String): List<AttendanceRecord> {
        return students.map { student ->
            val status = when (student.id) {
                4 -> AttendanceStatus.NGHI_CO_PHEP
                11 -> AttendanceStatus.DI_TRE
                22 -> AttendanceStatus.NGHI_KHONG_PHEP
                else -> AttendanceStatus.DI_HOC
            }
            val note = when (student.id) {
                4 -> "Gia đình báo bị cảm sốt"
                11 -> "Đến lớp trễ 15 phút do kẹt xe"
                22 -> "Chưa thấy phụ huynh liên hệ xin phép"
                else -> ""
            }
            AttendanceRecord(studentId = student.id, date = date, status = status, note = note)
        }
    }

    fun createInitialBehaviorLogs(date: String): List<BehaviorLog> {
        return listOf(
            BehaviorLog(
                studentId = 1,
                date = date,
                type = BehaviorType.PRAISE,
                category = "Hăng hái phát biểu",
                detail = "Tích cực xung phong lên bảng giải bài toán nâng cao."
            ),
            BehaviorLog(
                studentId = 3,
                date = date,
                type = BehaviorType.PRAISE,
                category = "Làm bài tập tốt",
                detail = "Hoàn thành xuất sắc bài tập Tiếng Việt, chữ viết rất sạch đẹp."
            ),
            BehaviorLog(
                studentId = 5,
                date = date,
                type = BehaviorType.PRAISE,
                category = "Giúp đỡ bạn bè",
                detail = "Nhiệt tình hướng dẫn bạn cùng bàn làm bài tập nhóm."
            ),
            BehaviorLog(
                studentId = 8,
                date = date,
                type = BehaviorType.REMIND,
                category = "Không làm bài tập",
                detail = "Chưa làm bài tập Toán trang 45 vở bài tập."
            ),
            BehaviorLog(
                studentId = 15,
                date = date,
                type = BehaviorType.REMIND,
                category = "Không viết bài",
                detail = "Mải nói chuyện, chưa chép đầy đủ bài Lịch sử vào vở."
            ),
            BehaviorLog(
                studentId = 16,
                date = date,
                type = BehaviorType.REMIND,
                category = "Không đội nón bảo hiểm",
                detail = "Phụ huynh chở đi học chưa cho em đội mũ bảo hiểm theo quy định an toàn giao thông."
            ),
            BehaviorLog(
                studentId = 22,
                date = date,
                type = BehaviorType.REMIND,
                category = "Vi phạm nội quy",
                detail = "Còn xô đẩy, trêu chọc bạn trong giờ ra chơi."
            ),
            BehaviorLog(
                studentId = 24,
                date = date,
                type = BehaviorType.PRAISE,
                category = "Siêng năng trực nhật",
                detail = "Tự giác quét dọn lớp học, lau bảng sạch sẽ trước giờ vào lớp."
            )
        )
    }

    val initialSchoolRequests = listOf(
        SchoolRequest(
            studentId = 4,
            title = "Nộp bổ sung thẻ Bảo hiểm Y tế",
            content = "Kính đề nghị phụ huynh chụp gửi bản photo thẻ BHYT năm 2025 để nhà trường cập nhật hồ sơ y tế học sinh.",
            deadline = "Trước thứ Sáu tuần này",
            isSent = true,
            sentDate = "Hôm nay",
            status = "Đã gửi Zalo"
        ),
        SchoolRequest(
            studentId = 8,
            title = "Nhắc nhở chuẩn bị bài vở ở nhà",
            content = "Nhờ phụ huynh kiểm tra cặp và đôn đốc em hoàn thành đủ bài tập về nhà trước khi đến lớp.",
            deadline = "Hàng ngày",
            isSent = true,
            sentDate = "Hôm nay",
            status = "Đã gửi Zalo"
        ),
        SchoolRequest(
            studentId = 16,
            title = "Cam kết đội mũ bảo hiểm khi tham gia giao thông",
            content = "Nhà trường nhắc nhở phụ huynh trang bị và nhắc em luôn đội mũ bảo hiểm đạt chuẩn khi đến trường.",
            deadline = "Thực hiện ngay",
            isSent = false,
            sentDate = "",
            status = "Chờ gửi Zalo"
        ),
        SchoolRequest(
            studentId = 22,
            title = "Mời phụ huynh trao đổi nề nếp của em",
            content = "Kính mời phụ huynh sắp xếp đến gặp GVCN vào lúc 16h30 thứ Năm để trao đổi việc rèn luyện nề nếp của em.",
            deadline = "16h30 Thứ Năm",
            isSent = false,
            sentDate = "",
            status = "Chờ gửi Zalo"
        ),
        SchoolRequest(
            studentId = 1,
            title = "Đăng ký tham gia vòng thi IOE cấp Trường",
            content = "Em có năng khiếu Tiếng Anh tốt, GVCN đề xuất phụ huynh đăng ký cho em tham gia thi Olympic Tiếng Anh.",
            deadline = "Hạn chót 25/10",
            isSent = true,
            sentDate = "Hôm qua",
            status = "Đã phản hồi đồng ý"
        )
    )

    fun createInitialSemesterResults(): List<SemesterResult> {
        val list = mutableListOf<SemesterResult>()
        students.forEach { student ->
            // Base variance based on student id
            val base = when {
                student.id in listOf(1, 3, 5, 13, 20, 24, 27, 30) -> 9.0
                student.id in listOf(8, 15, 16, 22) -> 7.0
                else -> 8.0
            }
            val offset = (student.id % 3) * 0.5

            TermType.values().forEach { term ->
                val math = (base + offset).coerceIn(6.0, 10.0)
                val tv = (base + if (student.gender == "Nữ") 0.5 else 0.0).coerceIn(6.0, 10.0)
                val eng = (base + offset * 0.5).coerceIn(6.0, 10.0)
                val sci = (base + 0.5).coerceIn(6.0, 10.0)
                val his = (base).coerceIn(6.0, 10.0)
                val info = (base + 0.5).coerceIn(6.0, 10.0)

                val avg = (math + tv + eng + sci + his + info) / 6.0
                val title = when {
                    avg >= 9.0 -> "Học sinh Xuất sắc"
                    avg >= 8.0 -> "Học sinh Tiêu biểu"
                    else -> "Hoàn thành tốt"
                }
                val conduct = if (avg >= 8.0) "Tốt" else "Đạt"
                val teacherNote = when {
                    avg >= 9.0 -> "Tiếp thu bài nhanh, gương mẫu, hăng hái xây dựng bài."
                    avg >= 8.0 -> "Chăm ngoan, học lực khá tốt, chữ viết cẩn thận."
                    else -> "Cần rèn thêm kỹ năng tính toán và chú ý hoàn thành bài tập về nhà."
                }

                list.add(
                    SemesterResult(
                        studentId = student.id,
                        term = term,
                        mathScore = (math * 10).toInt() / 10.0,
                        vietnameseScore = (tv * 10).toInt() / 10.0,
                        englishScore = (eng * 10).toInt() / 10.0,
                        scienceScore = (sci * 10).toInt() / 10.0,
                        historyGeoScore = (his * 10).toInt() / 10.0,
                        informaticsScore = (info * 10).toInt() / 10.0,
                        conduct = conduct,
                        title = title,
                        teacherNote = teacherNote
                    )
                )
            }
        }
        return list
    }
}
