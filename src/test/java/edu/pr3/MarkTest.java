package edu.pr3;

import edu.pr3.reports.Report;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MarkTest {

    public static final String PATH = "src/test/resources/logs*";
    List<String> expectedMarkDown = List.of(
        "## Общая информация",
        "|Метрика|Значение",
        "|---|---|",
        "|Файл 1|logs.txt",
        "|Начальная дата|-",
        "|Конечная дата|-",
        "|Количество запросов |3",
        "|Средний размер ответа|1610b",
        "",
        "## Запрашиваемые ресурсы",
        "|Ресурс|Количество",
        "|---|---|",
        "|/Robust%20web-enabled.gif|1",
        "|/Face%20to%20face.css|1",
        "|/definition.js|1",
        "",
        "## Коды ответа",
        "|Код|Описание|Количество",
        "|---|---|---|",
        "|200|OK|3",
        "",
        "## Удаленные адреса",
        "|Адрес|Количество",
        "|---|---|",
        "|﻿186.129.237.135|1",
        "|172.212.211.102|1",
        "|145.156.65.118|1",
        "",
        "## HTTP-методы",
        "|Метод|Количество",
        "|---|---|",
        "|GET|2",
        "|POST|1",
        ""
    );

    @Test
    void if_valid_log_and_markdown_file_should_generate_markdown_report_()
        throws IOException, URISyntaxException {
        InputAnalyzer.setToDate("-");
        InputAnalyzer.setFromDate("-");

        var info = PathReader.readPathOrUrl(PATH);
        var report = Report.generateReport("markdown", info.getAllStatstics());

        Assertions.assertThat(report).isEqualTo(expectedMarkDown);
    }

}
