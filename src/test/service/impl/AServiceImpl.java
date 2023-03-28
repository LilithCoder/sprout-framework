package test.service.impl;

import test.service.AService;

/**
 * @author gaoweilin
 * @date 2023/03/27 Mon 10:06 AM
 */
public class AServiceImpl implements AService {

    @Override
    public void invoke() {
        System.out.println("You got me!!!");
    }
}
