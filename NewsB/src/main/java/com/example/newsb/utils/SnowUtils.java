package com.example.newsb.utils;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;

public class SnowUtils {
    public static long setSnow(){

        short s=12;
        // 创建 IdGeneratorOptions 对象，可在构造函数中输入 WorkerId：
        IdGeneratorOptions options = new IdGeneratorOptions(s);
        YitIdHelper.setIdGenerator(options);
        long newId = YitIdHelper.nextId();
        return newId;
    }
}
