package com.example.stockmcp.service;

import com.example.stockmcp.entity.CompanyDetail;
import com.example.stockmcp.entity.StockSSJY;
import com.example.stockmcp.entity.StockTime;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class StockService {

    // 可向https://www.mairui.club/getlicence申请，每日可查询50次
    String license = "3B481864-FFE6-490F-85E0-767439447247";

    // 测试license 只支持股票代码000001 即平安银行
//    String license = "b997d4403688d5e66a";
    String url;

    @Tool(description = "根据股票代码获取股票实时交易信息（只支持沪深两市）")
    public StockSSJY getStockSSJY(@ToolParam(description = "股票代码") String stockCode) {
        url = "http://api.mairui.club/hsrl/ssjy/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + stockCode + "/" + license))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            ObjectMapper mapper = new ObjectMapper();
            StockSSJY stock = mapper.readValue(responseBody, StockSSJY.class);
            return stock;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Tool(description = "根据股票代码获取公司的详细信息（只支持沪深两市）")
    public CompanyDetail getCompanyDetail(@ToolParam(description = "股票代码") String stockCode) {
        url = "http://api.mairuiapi.com/hscp/gsjj/";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + stockCode + "/" + license))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            ObjectMapper mapper = new ObjectMapper();
            CompanyDetail companyDetail = mapper.readValue(responseBody, CompanyDetail.class);
            return companyDetail;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Tool(description = "根据股票代码和指定日期给出股票分时价格（只支持沪深两市）")
    public List<StockTime> getStockTimeByStartDayAndEndDat(@ToolParam(description = "股票代码") String stockCode,
                                                           @ToolParam(description = "起始日期，日期格式为yyyy-MM-dd") String startDay,
                                                           @ToolParam(description = "终止日期，日期格式为yyyy-MM-dd") String endDay) {
        url = "http://api.mairuiapi.com/hszbc/fsjy/";

        // 如果时间间隔大于60天，则只返回60天的数据，日期格式为yyyy-MM-dd
        if (startDay != null && !startDay.isEmpty() && endDay != null && !endDay.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date dateStart = formatter.parse(startDay);
                Date dateEnd = formatter.parse(endDay);
                long diff = dateEnd.getTime() - dateStart.getTime();
                long days = diff / (1000 * 60 * 60 * 24);
                if (days > 60) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dateEnd);
                    calendar.add(Calendar.DAY_OF_YEAR, -60);
                    startDay = formatter.format(calendar.getTime());
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + stockCode + "/d/" + startDay + "/" + endDay + "/" + license))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            ObjectMapper mapper = new ObjectMapper();
            List<StockTime> stockTimeList = mapper.readValue(responseBody,
                    mapper.getTypeFactory().constructCollectionType(List.class, StockTime.class));
            Collections.reverse(stockTimeList);
            return stockTimeList;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Tool(description = "根据股票代码和分时级别获取股价分时信息，分时级别分别为年，月，周，日（如果分时级别为周则返回30个周的数据，如果分时级别为日则返回30天的数据，只支持沪深两市）")
    public List<StockTime> getStockTimeByYearOrMonthOrWeekOrDay(@ToolParam(description = "股票代码") String stockCode,
                                                                @ToolParam(description = "分时级别，如果为年则参数为y，如果为月则参数为m，如果为周则参数为w，如果为日则参数为d")String time) {
        url = "https://api.mairui.club/hszbl/fsjy/";

        if (time.equals("w") || time.equals("d")){
            url = "http://api.mairuiapi.com/hszbc/fsjy/";
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
            Date dateEnd = new Date(System.currentTimeMillis());

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateEnd);
            if (time.equals("w")){
                calendar.add(Calendar.DAY_OF_YEAR, -210); // 减去30周
            }else{
                calendar.add(Calendar.DAY_OF_YEAR, -30); // 减去30天
            }
            Date dateStart = calendar.getTime();
            formatter.format(dateStart);
            formatter.format(dateEnd);
            time = time + "/" + formatter.format(dateStart) + "/" +formatter.format(dateEnd);
        }

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + stockCode + "/" + time + "/" + license))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            ObjectMapper mapper = new ObjectMapper();
            List<StockTime> stockTimeList = mapper.readValue(responseBody,
                    mapper.getTypeFactory().constructCollectionType(List.class, StockTime.class));
            Collections.reverse(stockTimeList);
            return stockTimeList;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Tool(description = "获取当前时间")
    public String getCurrentTime() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());

        return formatter.format(date);
    }


    public static void main(String[] args) {
        StockService stockService = new StockService();
        System.out.println(stockService.getStockTimeByStartDayAndEndDat("000001", "2025-01-03", "2025-04-17"));
    }



}
