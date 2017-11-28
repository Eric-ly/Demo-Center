//package demo.spring;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.util.HashMap;
//import java.util.Random;
//import java.util.Map;
//import java.util.concurrent.locks.ReentrantLock;
//
//import static javafx.concurrent.Worker.State.RUNNING;
//
//
///**
// * 动态代理类
// */
//public class dynamicProxy implements InvocationHandler {
//
//    //被代理的对象
//    Object targetObject;
//
//    /**
//     * 获得被代理后的对象
//     * @param object 被代理的对象
//     * @return 代理后的对象
//     */
//    public Object getProxyObject(Object object){
//        this.targetObject=object;
//        return Proxy.newProxyInstance(
//                targetObject.getClass().getClassLoader(), //类加载器
//                targetObject.getClass().getInterfaces(),  //获得被代理对象的所有接口
//                this);  //InvocationHandler对象
//        //loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来生成代理对象进行加载
//        //interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
//        //h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上，间接通过invoke来执行
//    }
//
//
//    /**
//     * 当用户调用对象中的每个方法时都通过下面的方法执行，方法必须在接口
//     * proxy 被代理后的对象
//     * method 将要被执行的方法信息（反射）
//     * args 执行方法时需要的参数
//     */
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        //被织入的内容，开始时间
//        long start=System.currentTimeMillis();
//        lazy();
//
//        //使用反射在目标对象上调用方法并传入参数
//        Object result=method.invoke(targetObject, args);
//
//        //被织入的内容，结束时间
//        Long span= System.currentTimeMillis()-start;
//        System.out.println("共用时："+span);
//
//        return result;
//    }
//
//    //模拟延时
//    public void lazy()
//    {
//        try {
//            int n=(int)new Random().nextInt(500);
//            Thread.sleep(n);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//
//    /*
//     * 动态代理类
//     * 实现了一个方法拦截器接口
//     */
//    public class DynamicProxy implements MethodInterceptor {
//
//        // 被代理对象
//        Object targetObject;
//
//        //动态生成一个新的类，使用父类的无参构造方法创建一个指定了特定回调的代理实例
//        public Object getProxyObject(Object object) {
//            this.targetObject = object;
//            //增强器，动态代码生成器
//            Enhancer enhancer=new Enhancer();
//            //回调方法
//            enhancer.setCallback(this);
//            //设置生成类的父类类型
//            enhancer.setSuperclass(targetObject.getClass());
//            //动态生成字节码并返回代理对象
//            return enhancer.create();
//        }
//
//        // 拦截方法
//        public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
//            // 被织入的横切内容，开始时间 before
//            long start = System.currentTimeMillis();
//            lazy();
//
//            // 调用方法
//            Object result = methodProxy.invoke(targetObject, args);
//
//            // 被织入的横切内容，结束时间
//            Long span = System.currentTimeMillis() - start;
//            System.out.println("共用时：" + span);
//
//            return result;
//        }
//
//        // 模拟延时
//        public void lazy() {
//            try {
//                int n = (int) new Random().nextInt(500);
//                Thread.sleep(n);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//    public class Solution {
//       public int[] twoSum(int[] nums, int target) {
//           Map<Integer,Integer> map=new HashMap<>();
//           for(int i=0;i<nums.length;i++){
//               Integer index=map.get(target-nums[i]);
//               if(index==null){
//                   map.put(nums[i],i);
//               }else{
//                   return new int[]{i,index};
//               }
//           }
//           return new int[]{0,0};
//       }
//   }
//    public void execute(Runnable command) {
//       if (command == null)
//           throw new NullPointerException();
//       if (poolSize >= corePoolSize || !addIfUnderCorePoolSize(command)) {
//           if (runState == RUNNING && workQueue.offer(command)) {
//               if (runState != RUNNING || poolSize == 0)
//                   ensureQueuedTaskHandled(command);
//           }
//           else if (!addIfUnderMaximumPoolSize(command))
//               reject(command); // is shutdown or saturated
//       }
//   }
//    private boolean addIfUnderCorePoolSize(Runnable firstTask) {
//       Thread t = null;
//       final ReentrantLock mainLock = this.mainLock;
//       mainLock.lock();
//       try {
//           if (poolSize < corePoolSize && runState == RUNNING)
//               t = addThread(firstTask);        //创建线程去执行firstTask任务
//           } finally {
//           mainLock.unlock();
//       }
//       if (t == null)
//           return false;
//       t.start();
//       return true;
//   }
//}
//
//private Thread addThread(Runnable firstTask) {
//   Worker w = new Worker(firstTask);
//   Thread t = threadFactory.newThread(w);  //创建一个线程，执行任务
//   if (t != null) {
//       w.thread = t;            //将创建的线程的引用赋值为w的成员变量
//       workers.add(w);
//       int nt = ++poolSize;     //当前线程数加1
//       if (nt > largestPoolSize)
//           largestPoolSize = nt;
//   }
//   return t;
//}