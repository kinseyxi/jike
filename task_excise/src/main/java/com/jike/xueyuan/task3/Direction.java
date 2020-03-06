package com.jike.xueyuan.task3;

public enum Direction {
    E(){
        @Override
        public Offset fowardOffset() {
            return new Offset(1,0);
        }

        @Override
        public Offset backOffset() {
            return new Offset(-1,0);
        }
    },W(){
        @Override
        public Offset fowardOffset() {
            return new Offset(-1,0);
        }

        @Override
        public Offset backOffset() {
            return new Offset(1,0);
        }
    },N(){
        @Override
        public Offset fowardOffset() {
            return new Offset(0,1);

        }

        @Override
        public Offset backOffset() {
            return new Offset(0,-1);
        }
    },S(){
        @Override
        public Offset fowardOffset() {
            return new Offset(0,-1);
        }

        @Override
        public Offset backOffset() {
            return new Offset(0,1);
        }
    };

    public abstract Offset fowardOffset();

    public abstract Offset backOffset();
}
