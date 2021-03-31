package com.c1020g1.demo.service.nation;

import com.c1020g1.demo.model.Nation;
import com.c1020g1.demo.service.IService;

public interface INationService extends IService<Nation> {
    Nation findByName(String name);
}
