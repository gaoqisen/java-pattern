package study.chainOfResponsibility;

/**
 * 对账抽象类(使用责任链模式处理数据)
 * @author jasongao
 * 处理流程:
 * 当前为初始化订单数据：初始化订单数据>初始化esc数据>对比账务>文件上传
 * 当前为初始化esc数据：初始化esc数据>对比账务>文件上传
 * 当前为对比账务：对比账务>文件上传
 * ...
 */
public abstract class ComparedAccount {

    /** 初始化订单数据 */
    public static int ORDER_INFO = 1;

    /** 初始化esc数据 */
    public static int ESC_INFO = 2;

    /** 对比账务 */
    public static int COMPARED_ACCOUNT = 3;

    /** 文件上传 */
    public static int FILE_UPLOAD = 4;

    protected  int level;

    public ComparedAccount netComparedAccount;

    public void setNetComparedAccount(ComparedAccount netComparedAccount) {
        this.netComparedAccount = netComparedAccount;
    }

    public void start(ComparedAccountEntity comparedAccountEntity ){
       if(this.level >= comparedAccountEntity.getStatus()) {
            execute(comparedAccountEntity);
       }

       if(netComparedAccount != null) {
           netComparedAccount.start(comparedAccountEntity);
       }
    }

    public abstract void execute(ComparedAccountEntity comparedAccountEntity);


    public static void main(String[] args) {
        // 初始化责任链
        ComparedAccount initComparedAccount = new OrderInfo(ComparedAccount.ORDER_INFO);
        ComparedAccount escInfo = new EscInfo(ComparedAccount.ESC_INFO);
        initComparedAccount.setNetComparedAccount(escInfo);

        ComparedAccountMain comparedAccountMain = new ComparedAccountMain(ComparedAccount.COMPARED_ACCOUNT);
        escInfo.setNetComparedAccount(comparedAccountMain);

        FileUpload fileUpload = new FileUpload(ComparedAccount.FILE_UPLOAD);
        comparedAccountMain.setNetComparedAccount(fileUpload);

        // 根据对账文件数据状态进行相应的处理, 状态从数据库里面里面获取
        ComparedAccountEntity comparedAccountEntity = new ComparedAccountEntity();
        comparedAccountEntity.setStatus(ComparedAccount.COMPARED_ACCOUNT);
        initComparedAccount.start(comparedAccountEntity);
    }

}

/**
 * 订单信息获取并记录数据
 */
class OrderInfo extends ComparedAccount{

    public OrderInfo(int level) {
        this.level = level;
    }

    @Override
    public void execute(ComparedAccountEntity comparedAccountEntity) {
        System.out.println("1.订单信息获取并且入库");
    }
}

/**
 * 从esc的sftp上面下载文件并入库
 */
class EscInfo extends ComparedAccount{

    public EscInfo(int level) {
        this.level = level;
    }

    @Override
    public void execute(ComparedAccountEntity comparedAccountEntity) {
        System.out.println("2.esc信息获取并且入库");
    }
}

/**
 * 进行数据主要对账逻辑操作
 */
class ComparedAccountMain extends ComparedAccount{

    public ComparedAccountMain(int level) {
        this.level = level;
    }

    @Override
    public void execute(ComparedAccountEntity comparedAccountEntity) {
        System.out.println("3.主要对账逻辑处理");
    }
}

/**
 * 文件上传到第三方的sftp文件服务器
 */
class FileUpload extends ComparedAccount{

    public FileUpload(int level) {
        this.level = level;
    }

    @Override
    public void execute(ComparedAccountEntity comparedAccountEntity) {
        System.out.println("4.文件上传处理");
    }
}

/**
 * 对账信息表实体
 */
class ComparedAccountEntity{

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
