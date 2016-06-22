package com.clientsbox.logic.services.helper;

import java.util.ArrayList;
import java.util.List;

public class xMatcherHelper {
    
    public interface XMatcher<T>{
        public boolean xmatches(T t);
    }
    
    public <T> List<T> searchIn(List<T> mList, XMatcher<T> mMatcher){
        List<T> mListT = new ArrayList<>();
        for (T t: mList) {
            if (mMatcher.xmatches(t)){
                mListT.add(t);
            }
        }
        return mListT;
    }
}
