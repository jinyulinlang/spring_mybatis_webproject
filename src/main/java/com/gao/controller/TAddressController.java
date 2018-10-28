package com.gao.controller;

import com.alibaba.fastjson.JSONObject;
import com.gao.model.TAddress;
import com.gao.service.TAddressSevice;
import com.gao.utils.AJaxModel;
import com.gao.utils.BaseForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("tAddressController")
public class TAddressController {
    private static final Logger log = LoggerFactory.getLogger(TAddressController.class);
    @Autowired
    private TAddressSevice tAddressSevice;

    /**
     * 根据主键删除一条记录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/deleteByPrimaryKey", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"text/plain", "application/*"})
    @ResponseBody
    public AJaxModel deleteByPrimaryKey(HttpServletRequest request, HttpServletResponse response) {
        AJaxModel aJaxModel = new AJaxModel();
        log.info("開始删除----------");
        Integer id = Integer.parseInt(request.getParameter("id"));
        int i = tAddressSevice.deleteByPrimaryKey(id);
        if (i > 0) {
            aJaxModel.setResponseMsg("删除成功");
        } else {
            log.info("删除失败");
        }
        return aJaxModel;
    }

    /**
     * 保存一条记录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/insert", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"text/plain", "application/*"})
    @ResponseBody
    public AJaxModel insert(TAddress tAddress, HttpServletRequest request, HttpServletResponse response) {
        AJaxModel aJaxModel = new AJaxModel();
        log.info("開始删除----------");
        try {
            int insert = tAddressSevice.insert(tAddress);
            if (insert > 0) {
                log.info("新增成功----");
                aJaxModel.setResponseMsg("新增成功");
            } else {
                log.info("新增失敗");
                aJaxModel.setResponseCode("2");
                aJaxModel.setResponseMsg("新增失敗");
            }
        } catch (Exception e) {
            log.error("新增異常----");
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg("新增失敗");
        }
        return aJaxModel;
    }

    /**
     * 保存一条记录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/insertSelective", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"text/plain", "application/*"})
    @ResponseBody
    public AJaxModel insertSelective(TAddress tAddress, HttpServletRequest request, HttpServletResponse response) {
        AJaxModel aJaxModel = new AJaxModel();
        log.info("開始删除----------");
        try {
            int insert = tAddressSevice.insertSelective(tAddress);
            if (insert > 0) {
                log.info("新增成功----");
                aJaxModel.setResponseMsg("新增成功");
            } else {
                log.info("新增失敗");
                aJaxModel.setResponseCode("2");
                aJaxModel.setResponseMsg("新增失敗");
            }
        } catch (Exception e) {
            log.error("新增異常----", e);
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg("新增失敗");
        }
        return aJaxModel;
    }

    /**
     * 保存一条记录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/selectByPrimaryKey", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public AJaxModel selectByPrimaryKey(BaseForm baseForm ,HttpServletRequest request, HttpServletResponse response) {
        AJaxModel aJaxModel = new AJaxModel();

        log.info("開始删除----------");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            TAddress tAddress = tAddressSevice.selectByPrimaryKey(id);
            if (!StringUtils.isEmpty(tAddress)) {
                log.info("查詢成功----");
                aJaxModel.setResponseMsg("查詢成功");
                aJaxModel.setData(tAddress);
                Object o = (JSONObject) JSONObject.toJSON(aJaxModel);
                String s = ((JSONObject) o).toJSONString();
                log.info("查詢結果：" + s);
            } else {
                log.info("您查詢的對象不存在");
                aJaxModel.setResponseCode("2");
                aJaxModel.setResponseMsg("您查詢的對象不存在");
            }
        } catch (Exception e) {
            log.error("查詢異常----", e);
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg("查詢失敗");
        }
        return aJaxModel;
    }

    /**
     * 保存一条记录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateByPrimaryKeySelective", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"text/plain", "application/*"})
    @ResponseBody
    public AJaxModel updateByPrimaryKeySelective(TAddress tAddress, HttpServletRequest request, HttpServletResponse response) {
        AJaxModel aJaxModel = new AJaxModel();
        log.info("開始删除----------");
        try {
            if (!StringUtils.isEmpty(tAddress)) {
                int i = tAddressSevice.updateByPrimaryKeySelective(tAddress);
                if (i > 0) {
                    log.info("更新成功----");
                    aJaxModel.setResponseMsg("更新成功");
                } else {
                    log.info("更新失敗");
                    aJaxModel.setResponseCode("2");
                    aJaxModel.setResponseMsg("更新失敗");
                }
            } else {
                log.info("必輸項不能爲空");
                aJaxModel.setResponseMsg("必輸項不能爲空");
            }
        } catch (Exception e) {
            log.error("查詢異常----", e);
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg("查詢失敗");
        }
        return aJaxModel;
    }

    /**
     * 保存一条记录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/updateByPrimaryKey", method = {RequestMethod.POST, RequestMethod.GET}, produces = {"text/plain", "application/*"})
    @ResponseBody
    public AJaxModel updateByPrimaryKey(TAddress tAddress, HttpServletRequest request, HttpServletResponse response) {
        AJaxModel aJaxModel = new AJaxModel();
        log.info("開始删除----------");
        try {
            if (!StringUtils.isEmpty(tAddress) & !StringUtils.isEmpty(tAddress.getId())) {
                int i = tAddressSevice.updateByPrimaryKey(tAddress);
                if (i > 0) {
                    log.info("更新成功----");
                    aJaxModel.setResponseMsg("更新成功");
                } else {
                    log.info("更新失敗");
                    aJaxModel.setResponseCode("2");
                    aJaxModel.setResponseMsg("更新失敗");
                }
            } else {
                log.info("必輸項不能爲空");
                aJaxModel.setResponseMsg("必輸項不能爲空");
            }
        } catch (Exception e) {
            log.error("查詢異常----", e);
            aJaxModel.setResponseCode("2");
            aJaxModel.setResponseMsg("查詢失敗");
        }
        return aJaxModel;
    }


}
