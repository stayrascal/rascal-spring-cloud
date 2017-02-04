package com.stayrascal.api.users.model.rels;

import com.stayrascal.api.users.model.nodes.User;

public class Follows {
    private Long id;
    private User follower;
    private User follows;

    public Follows() {
    }

    public Long getId() {
        return id;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollows() {
        return follows;
    }

    public void setFollows(User follows) {
        this.follows = follows;
    }
}
