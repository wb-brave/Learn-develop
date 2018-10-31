nio（重点在通道和缓冲器）
    提高性能-->使用与操作系统执行IO方式更接近的结构
        通道以及缓冲器
    使用基础的ByteBuffer,进行原始的字节操作
    
对以下三个流进行了改造(都是基于字节操作的流  注意区分)，来生成FileChannel
    FileInputStream
    FileOutputStream
    RandomAccesssFile

对于字符流
    nio使用Channels类提供了方法，在通道中生产Reader以及Writer