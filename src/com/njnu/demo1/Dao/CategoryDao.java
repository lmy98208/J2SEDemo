package com.njnu.demo1.Dao;

import com.njnu.demo1.Bean.Category;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends BaseDao{

    public List<Category> findAll()
    {
        String sql="select * from category";
        //return findBySql(sql);
        return this.getListBySql(Category.class,sql);
    }
    /**
     * 根据id查找
     * @param objects
     * @return
     */
    public List<Category> findById(Object ...objects){
        String sql="select * from category where id=?";
        //return findBySql(sql,objects);
        return this.getListBySql(Category.class,sql,objects);
    }

    /**
     * 查询数据库，返回所有记录
     * @param sql
     * @param objects
     * @return
     */
    private List<Category> findBySql(String sql,Object ...objects)
    {
        List<Category> list=new ArrayList<>();
        ResultSet rs=this.query(sql,objects);
        try {
            while (rs.next()){
                Category category=new Category();
                category.setId(rs.getInt("id"));
                category.setCategory(rs.getString("category"));
                category.setRemark(rs.getString("remark"));
                list.add(category);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }
}
