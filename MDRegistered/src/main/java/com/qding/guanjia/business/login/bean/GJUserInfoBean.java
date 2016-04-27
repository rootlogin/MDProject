package com.qding.guanjia.business.login.bean;


import java.util.List;

/**
 * Created by liuyonglong on 16/3/2.
 */
public class GJUserInfoBean extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * accountId : 8aa57dca534f2bde0153541cc9ab002d
     * nickName :
     * rongCloudToken :
     * sourceType : 71
     * status : 1
     * type : 0
     */

    private AccountEntityEntity accountEntity;//管家用户账户信息
    /**
     * gender : -1
     * headImg :
     * memberId : 8aa57dca534f2bde0153541cc9ab002e
     * mobile : 13800138001
     * name : 千丁用户
     * serviceStatus : 1
     */

    private MemberEntityEntity memberEntity;//管家用户会员信息
    /**
     * accountEntity : {"accountId":"8aa57dca534f2bde0153541cc9ab002d","nickName":"","rongCloudToken":"","sourceType":71,"status":1,"type":0}
     * hkIdentityList : [{"identityId":"ff808181534175720153417572980000","identityName":"HKTestData"}]
     * memberEntity : {"gender":-1,"headImg":"","memberId":"8aa57dca534f2bde0153541cc9ab002e","mobile":"13800138001","name":"千丁用户","serviceStatus":1}
     * message :
     * partnerUserInfoList : [{"partnerId":"ff80818153541ccc0153541ccc9f0000","partnerType":"bs"},{"partnerId":"","partnerType":"hk"}]
     * projectIdList : [35,37]
     * projectList : [{"cityId":"1","cityName":"北京","concats":[],"groups":[],"id":"35","name":"长楹天街(已作废)"},{"cityId":"1","cityName":"北京","concats":[],"groups":[],"id":"37","name":"颐和原著"}]
     * userToken : v1_UU5LQm56KzdLYnJSL0V2WFQ4eUQyQjFZOGcvTW4vSzJadnlIcExyRERBWmpnc2s2cFJub2ZEV3B6MmNmNitKcGdWVlBFZUxEbGRVbXFGOG9KTURZOXN0WGJWQzZLYWswSUYzdy9JNUEraFNzSnl2MHd5Rnd0YlBqYUNyZ08rSytDd04vUjJaL1RKek5OcWVndmJnTUF2T24xS3NkNHZXTnF6WUVHMEFzSmo4WWNBdTQ5T3k2QkRHOElvSTNLRWIrZ0RRTVQrT09ZdmZLUnVzT0cwc2p3VVBzVFJVVTVESGM5TGtrSnMyQUhGNzZVQzdnRzFMcFI2eVVUQU9vYWwwUzR4WUY2YTRSMlpXNzhPSTZFTStSNFVuc2NUYkxmbnloZTI2Y2tWKzBwV3c2TU55cXB3VWRVYUp3Wk8vVjgveUpTBjGt636YDkdkfIXeVhtYYqnxzKGFH1-THI7FQ4MGjlsJQKRTMprC8RcDpMPHBmFaFp_wp-11j1Dmhu3Vdm5zM-gAqZjcDC5pyjEYlj5qmCG_brBkHMk-NGv9su7AyIjIVZVR1ldi4_LeKucXyk7ExAXJeTqyfTKDPPHjtHUmXw..
     */

    private String message;
    private String userToken;//登陆后Token
    /**
     * identityId : ff808181534175720153417572980000
     * identityName : HKTestData
     */

    private List<HkIdentityListEntity> hkIdentityList;//身份职责
    /**
     * partnerId : ff80818153541ccc0153541ccc9f0000
     * partnerType : bs
     */

    private List<PartnerUserInfoListEntity> partnerUserInfoList;//账户来源信息
    private List<String> projectIdList;//社区ID列表
    /**
     * cityId : 1
     * cityName : 北京
     * concats : []
     * groups : []
     * id : 35
     * name : 长楹天街(已作废)
     */

    private List<ProjectListEntity> projectList;//社区信息列表

    public void setAccountEntity(AccountEntityEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public void setMemberEntity(MemberEntityEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public void setHkIdentityList(List<HkIdentityListEntity> hkIdentityList) {
        this.hkIdentityList = hkIdentityList;
    }

    public void setPartnerUserInfoList(List<PartnerUserInfoListEntity> partnerUserInfoList) {
        this.partnerUserInfoList = partnerUserInfoList;
    }

    public void setProjectIdList(List<String> projectIdList) {
        this.projectIdList = projectIdList;
    }

    public void setProjectList(List<ProjectListEntity> projectList) {
        this.projectList = projectList;
    }

    public AccountEntityEntity getAccountEntity() {
        return accountEntity;
    }

    public MemberEntityEntity getMemberEntity() {
        return memberEntity;
    }

    public String getMessage() {
        return message;
    }

    public String getUserToken() {
        return userToken;
    }

    public List<HkIdentityListEntity> getHkIdentityList() {
        return hkIdentityList;
    }

    public List<PartnerUserInfoListEntity> getPartnerUserInfoList() {
        return partnerUserInfoList;
    }

    public List<String> getProjectIdList() {
        return projectIdList;
    }

    public List<ProjectListEntity> getProjectList() {
        return projectList;
    }








}
