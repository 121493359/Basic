package com.android.core.model.control;


import com.android.core.model.annotation.Implement;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: 蜡笔小新
 * @date: 2016-05-31 14:15
 * @GitHub: https://github.com/meikoz
 */
public class LogicProxy {
    private static final LogicProxy m_instance = new LogicProxy();
    Map<Object, List<BaseLogic>> m_bind_info;

    public static LogicProxy getInstance() {
        return m_instance;
    }

    private LogicProxy() {
        m_objects = new HashMap<>();
    }

    private Map<Class, Object> m_objects;

    public void init(Class... clss) {
        List<Class> list = new LinkedList<Class>();
        for (Class cls : clss) {
            if (cls.isAnnotationPresent(Implement.class)) {
                list.add(cls);
                for (Annotation ann : cls.getDeclaredAnnotations()) {
                    if (ann instanceof Implement) {
                        try {
                            m_objects.put(cls, ((Implement) ann).value().newInstance());
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public <T> T getProxy(Class cls) {
        return (T) m_objects.get(cls);
    }

    public <T> T bind(Class cls, Object o) {
        Object ret = m_objects.get(cls);
        ((BaseLogic) ret).attachView(o);
        List<BaseLogic> bls = m_bind_info.get(o);
        if(bls != null) {
            boolean exist = false;
            for(BaseLogic bl : bls) {
                if(ret.equals(bl)) {
                    exist = true;
                    break;
                }
            }
            if(!exist) {
                bls.add((BaseLogic)ret);
                m_bind_info.put(o, bls);
            }
        } else {
            bls = new ArrayList<>();
            bls.add((BaseLogic)ret);
            m_bind_info.put(o, bls);
        }
        return (T) ret;
    }

    public void unbind(Object o) {
        List<BaseLogic> bls = m_bind_info.get(o);
        if(bls != null) {
            for(BaseLogic bl : bls) {
                //bl.unbind();
            }
        }
        m_bind_info.remove(o);
    }
}
