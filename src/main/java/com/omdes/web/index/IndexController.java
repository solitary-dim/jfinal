package com.omdes.web.index;

import com.jfinal.core.Controller;

import static com.omdes.web.WebForwardConstant.FWD_INDEX;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/13
 * Time: 16:47
 */
public class IndexController extends Controller {

    public void index(){
        renderJsp(FWD_INDEX);
    }
}
