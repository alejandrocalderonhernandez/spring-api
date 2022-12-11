package com.debuggeando_ideas.service;

import com.debuggeando_ideas.entity.TrackEntity;
import com.debuggeando_ideas.service.common.SimpleService;

public interface ITrackService extends SimpleService<TrackEntity>{

    public void delete(Long id);
}
