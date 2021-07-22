package main

import (
	"fmt"
	"sync"
)

func main() {
	q := New()
	wg := sync.WaitGroup{}

	wg.Add(2)
	go func() {
		defer wg.Done()
		for i := 0; i < 15; i++ {
			q.InQueue(i)
		}
	}()

	go func() {
		defer wg.Done()
		for i := 0; i < 15; i++ {
			item := q.DeQueue()
			fmt.Println(item)
		}
	}()

	wg.Wait()
}

// Queue 队列对象
type Queue struct {
	values []interface{}
	cond   *sync.Cond
}

// New Queue类的构造函数
func New() *Queue {
	val := make([]interface{}, 0)
	con := sync.NewCond(new(sync.Mutex))
	return &Queue{
		values: val,
		cond:   con,
	}
}

func (queue *Queue) lock() sync.Locker {
	return queue.cond.L
}

// InQueue 入队操作
func (queue *Queue) InQueue(value interface{}) {
	queue.lock().Lock()
	defer func() {
		queue.lock().Unlock()
	}()

	queue.values = append(queue.values, value)
	//发送单个通知
	queue.cond.Signal()
	//Broadcast方法却可以唤醒所有为此而等待的 goroutine
	queue.cond.Broadcast()
}

// IsEmpty 判断队列是否为空
func (q *Queue) IsEmpty() bool {
	q.lock().Lock()
	defer q.lock().Unlock()
	q.cond.Signal()
	q.cond.Broadcast()
	return len(q.values) == 0
}

// DeQueue 出队操作
func (q *Queue) DeQueue() interface{} {
	q.lock().Lock()
	if len(q.values) == 0 {
		//等待通知
		q.cond.Wait()
	}
	defer q.lock().Unlock()
	value := q.values[0]
	q.values = q.values[1:]
	q.cond.Signal()
	q.cond.Broadcast()
	return value
}
