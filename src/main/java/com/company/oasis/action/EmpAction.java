package com.company.oasis.action;

import com.company.oasis.comm.ResponseResult;
import com.company.oasis.comm.Result;
import com.company.oasis.dao.pojo.Emp;
import com.company.oasis.service.iservice.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpAction {
    @Autowired
    EmpService empService;

@RequestMapping(value = "emp",method = RequestMethod.POST)
public @ResponseBody ResponseResult<Emp> save(Emp emp){
    String msg = empService.save(emp);
    int code = Result.SUCCESS.equals(msg)?200:500;
    return  new ResponseResult<Emp>(code,msg);
}
    @RequestMapping(value = "emp",method = RequestMethod.PUT)
    public @ResponseBody ResponseResult<Emp> update(Emp emp){
        String msg = empService.update(emp);
        int code = Result.SUCCESS.equals(msg)?200:500;
        return  new ResponseResult<Emp>(code,msg);
    }
    @RequestMapping(value = "emp/{empno}",method = RequestMethod.DELETE)
    public @ResponseBody ResponseResult<Emp> delete(@PathVariable("empno") Integer empno){
        String msg = empService.delete(empno);
        int code = Result.SUCCESS.equals(msg)?200:500;
        return  new ResponseResult<Emp>(code,msg);
    }
    @RequestMapping("emps")
    public @ResponseBody ResponseResult<List<Emp>> findByPage(
            @RequestParam(value = "page",required = false,defaultValue = "1") int page,
            @RequestParam(value = "size",required = false,defaultValue = "1") int size){
List<Emp> emps = empService.findByPage(page,size);
if(emps!=null && emps.size()>0){
    return  new ResponseResult<List<Emp>>(200,Result.SUCCESS,emps);

}else{
    return  new ResponseResult<List<Emp>>(500,Result.ERROR);
}
    }
    @RequestMapping("emp/{empno}")
    public @ResponseBody ResponseResult<Emp> findById(@PathVariable("empno") Integer empno){
    Emp emp = empService.findById(empno);
        if(emp!=null ){
            return  new ResponseResult<Emp>(200,Result.SUCCESS,emp);

        }else{
            return  new ResponseResult<Emp>(500,Result.ERROR);
        }
    }
    @RequestMapping("emps/{ename}")
    public @ResponseBody ResponseResult<List<Emp>> findByName(@PathVariable("ename") String ename){
        List<Emp> emps = empService.findByName(ename);
        if(emps!=null && emps.size()>0){
            return  new ResponseResult<List<Emp>>(200,Result.SUCCESS,emps);

        }else{
            return  new ResponseResult<List<Emp>>(500,Result.ERROR);
        }
    }

}
