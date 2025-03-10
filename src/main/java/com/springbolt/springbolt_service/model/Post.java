package com.springbolt.springbolt_service.model;


    public class Post {
        private int userId;
        private int id;
        private String title;
        private String body;

        // Getters and Setters
        public int getUserId() { return userId; }
        public void setUserId(int userId) { this.userId = userId; }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getBody() { return body; }
        public void setBody(String body) { this.body = body; }

        // toString() for easy debugging
        @Override
        public String toString() {
            return "Post{" +
                    "userId=" + userId +
                    ", id=" + id +
                    ", title='" + title + '\'' +
                    ", body='" + body + '\'' +
                    '}';
        }
    }


