package com.jk.controller;

import com.jk.dao.JworkRepository;
import com.jk.model.Zwjl;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("zhf")
@Controller
public class ZhfController {

    @RequestMapping("showwork")
    public String showwork(){
        return "showwork";
    }

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private JworkRepository jworkRepository;


    @RequestMapping("search1")
    public String search1(String wk, Model model){
        //    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //对电影名称进行模糊查询并设置高亮
        //对作者，id进行精确查询

        //创建组合查询组件
        Map<String, Object> map = new HashMap<>();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        if (wk!=null &&!"".equals(wk)){
            //must代表必须返回
            //mustnot代表必须不
            //filter代表过滤
            //matchquery代表查询所有
            //tearmquery精确查询
            //rangequery区间查询
            boolQueryBuilder.must(QueryBuilders.matchQuery("zhiw",wk));
        }


        //获取高亮组件
           /* HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.field("jname");//设置高亮字段
            highlightBuilder.preTags("<span style='color:red;'>");//设置前缀
            highlightBuilder.postTags("</span>");//设置后缀*/

        SearchRequestBuilder searchRequestBuilder = elasticsearchTemplate.getClient().prepareSearch("work")
                //.setSearchType("bookaction")//设置查询索引类型
                .setQuery(boolQueryBuilder)//设置查询索引策略
                .addSort("id", SortOrder.ASC)//对id字段进行倒序
                //  .highlighter(highlightBuilder)//设置高亮
                .setExplain(true); //设置是否对相关度排序


        //获取响应组件
        SearchResponse searchResponse =searchRequestBuilder.get();
        SearchHits hits = searchResponse.getHits();

        //获取到符合条件的总条数
        long totalHits = hits.totalHits;

        //返回的数据
        SearchHit[] hits1 = hits.getHits();
        List<Zwjl> jworks = new ArrayList<>();

        for (SearchHit hit :hits1){
            Zwjl jwork = new Zwjl();

            //获取到查询的数据中的高亮字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField zhiw = highlightFields.get("zhiw");
            if (zhiw==null){//如果为空就用普通字段代替
                jwork.setZhiw(hit.getSourceAsMap().get("zhiw").toString());
            }else{//如果不为空就展示高亮字段
                jwork.setZhiw(zhiw.fragments()[0].toString());
            }
            jwork.setId((Integer) hit.getSourceAsMap().get("id"));
            jwork.setJingy( (String)hit.getSourceAsMap().get("jingy"));
            jwork.setMinsalary((Integer) hit.getSourceAsMap().get("minsalary"));
            jwork.setMaxsalary((Integer) hit.getSourceAsMap().get("maxsalary"));
            jwork.setDiq((String) hit.getSourceAsMap().get("diq"));
            jwork.setJingy((String) hit.getSourceAsMap().get("jingy"));
            jwork.setXuel((String) hit.getSourceAsMap().get("xuel"));
            jwork.setLianxr((String) hit.getSourceAsMap().get("lianxr"));
            jwork.setGongsmc((String) hit.getSourceAsMap().get("gongsmc"));
            jwork.setGongsxz((String) hit.getSourceAsMap().get("gongsxz"));
            jwork.setYuangrs((String) hit.getSourceAsMap().get("yuangrs"));
            jworks.add(jwork);
        }
        //   map.put("total",totalHits);
        //   map.put("rows",books);
        //  return map;
        model.addAttribute("jwork",jworks);
        model.addAttribute("wk",wk);
        return "boss2";
    }


    @RequestMapping("search2")
    public String search2(String wk,int xz, int xl,int jy,Model model){
        //    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //对电影名称进行模糊查询并设置高亮
        //对作者，id进行精确查询

        //创建组合查询组件

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        if (wk!=null &&!"".equals(wk)){
            boolQueryBuilder.must(QueryBuilders.matchQuery("zhiw",wk));

        }
        if(xz !=0){
            if(xz ==1){
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("minsalary").gte(10000));
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("minsalary").lte(15000));
            }
            else if(xz ==2){
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("minsalary").gte(15000));
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("minsalary").lte(20000));
            }
            else if(xz ==3){
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("minsalary").gte(20000));
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("minsalary").lte(30000));
            }
        }
        if(xl != 0){
            //must代表必须返回
            //mustnot代表必须不
            //filter代表过滤
            //matchquery代表查询所有
            //tearmquery精确查询
            //rangequery区间查询
              if(xl ==1){
                boolQueryBuilder.filter(QueryBuilders.termQuery("xuel","大专以下"));
            }
            else if(xl ==2){
                boolQueryBuilder.filter(QueryBuilders.termQuery("xuel","大专"));
            }
            else  if(xl ==3){
                boolQueryBuilder.filter(QueryBuilders.termQuery("xuel","本科"));
            }
            else if(xl ==4){
                boolQueryBuilder.filter(QueryBuilders.termQuery("xuel","博士"));
            }
            else if(xl ==5){
                boolQueryBuilder.filter(QueryBuilders.termQuery("xuel","硕士"));
              }

        }
        if(jy != 0){
            //must代表必须返回
            //mustnot代表必须不
            //filter代表过滤
            //matchquery代表查询所有
            //tearmquery精确查询
            //rangequery区间查询
             if(jy ==1){
                boolQueryBuilder.filter(QueryBuilders.termQuery("jingy","1到2年"));
            }
            else if(jy ==2){
                boolQueryBuilder.filter(QueryBuilders.termQuery("jingy","2到5年"));
            }
            else if(jy ==3){
                boolQueryBuilder.filter(QueryBuilders.termQuery("jingy","3到5年"));
            }
            else  if(jy ==4){
                boolQueryBuilder.filter(QueryBuilders.termQuery("jingy","6到8年"));
            }



        }

        SearchRequestBuilder searchRequestBuilder = elasticsearchTemplate.getClient().prepareSearch("work")
                //.setSearchType("bookaction")//设置查询索引类型
                .setQuery(boolQueryBuilder)//设置查询索引策略
                .addSort("id", SortOrder.ASC)//对id字段进行倒序
                //  .highlighter(highlightBuilder)//设置高亮
                .setExplain(true); //设置是否对相关度排序


        //获取响应组件
        SearchResponse searchResponse =searchRequestBuilder.get();
        SearchHits hits = searchResponse.getHits();



        //返回的数据
        SearchHit[] hits1 = hits.getHits();
        List<Zwjl> jworks = new ArrayList<>();

        for (SearchHit hit :hits1){
            Zwjl jwork = new Zwjl();
            //获取到查询的数据中的高亮字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField zhiw = highlightFields.get("jname");
            if (zhiw==null){//如果为空就用普通字段代替
                jwork.setZhiw(hit.getSourceAsMap().get("zhiw").toString());
            }else{//如果不为空就展示高亮字段
                jwork.setZhiw(zhiw.fragments()[0].toString());
            }
            jwork.setId((Integer) hit.getSourceAsMap().get("id"));
            jwork.setJingy( (String)hit.getSourceAsMap().get("jingy"));
            jwork.setMinsalary((Integer) hit.getSourceAsMap().get("minsalary"));
            jwork.setMaxsalary((Integer) hit.getSourceAsMap().get("maxsalary"));
            jwork.setDiq((String) hit.getSourceAsMap().get("diq"));
            jwork.setJingy((String) hit.getSourceAsMap().get("jingy"));
            jwork.setXuel((String) hit.getSourceAsMap().get("xuel"));
            jwork.setLianxr((String) hit.getSourceAsMap().get("lianxr"));
            jwork.setGongsmc((String) hit.getSourceAsMap().get("gongsmc"));
            jwork.setGongsxz((String) hit.getSourceAsMap().get("gongsxz"));
            jwork.setYuangrs((String) hit.getSourceAsMap().get("yuangrs"));
            jworks.add(jwork);
        }

        model.addAttribute("jwork",jworks);
        model.addAttribute("wk",wk);
        model.addAttribute("xz",xz);
        model.addAttribute("xl",xl);
        model.addAttribute("jy",jy);
        return "boss2";
    }
}
