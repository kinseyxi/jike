package com.jike.xueyuan.task3_2;

public enum Direction {
    E(){
        @Override
        public Direction left() {
            return N;
        }

        @Override
        public Direction right() {
            return S;
        }

        @Override
        public Offset forwardOffset() {
            return new Offset(1,0);
        }

        @Override
        public Offset backOffset() {
            return new Offset(-1,0);
        }
    },W(){
        @Override
        public Direction left() {
            return S;
        }

        @Override
        public Direction right() {
            return N;
        }

        @Override
        public Offset forwardOffset() {
            return new Offset(-1,0);
        }

        @Override
        public Offset backOffset() {
            return new Offset(1,0);
        }
    }
    ,S(){
        @Override
        public Direction left() {
            return E;
        }

        @Override
        public Direction right() {
            return W;
        }

        @Override
        public Offset forwardOffset() {
            return new Offset(0,-1);
        }

        @Override
        public Offset backOffset() {
            return new Offset(0,1);
        }
    },N(){
        @Override
        public Direction left() {
            return W;
        }

        @Override
        public Direction right() {
            return E;
        }

        @Override
        public Offset forwardOffset() {
            return new Offset(0,1);
        }

        @Override
        public Offset backOffset() {
            return new Offset(0,-1);
        }
    };

    public abstract Direction left();

    public abstract Direction right();

    public abstract Offset forwardOffset();

    public abstract Offset backOffset();
}
