package com.weiguan.functions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.threads.JMeterVariables;
import org.apache.jmeter.util.JMeterUtils;

public class RandomX extends AbstractFunction {
	 private static final List<String> desc = new LinkedList<String>();
	    private static final String KEY = "__RandomX"; //$NON-NLS-1$

	    static {
	        desc.add(JMeterUtils.getResString("minimum_param")); //$NON-NLS-1$
	        desc.add(JMeterUtils.getResString("maximum_param")); //$NON-NLS-1$
	        desc.add(JMeterUtils.getResString("function_name_paropt")); //$NON-NLS-1$
	    }

	    private CompoundVariable varName; 
	    private CompoundVariable minimum;
	    private CompoundVariable maximum;

	    /**
	     * No-arg constructor.
	     */
	    public RandomX() {
	    }

	    /** {@inheritDoc} */
	    @Override
	    public String execute(SampleResult previousResult, Sampler currentSampler)
	            throws InvalidVariableException {


	        long min = Long.parseLong(minimum.execute().trim());
	        long max = Long.parseLong(maximum.execute().trim());

	        long rand = ThreadLocalRandom.current().nextLong(min, max+1);

	        String xx = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟";
	        int i = (int)(Math.random()*(xx.length()));
	    	String randString = xx.substring(i,i+1);

	        if (varName != null) {
	            JMeterVariables vars = getVariables();
	            final String varTrim = varName.execute().trim();
	            if (vars != null && varTrim.length() > 0){// vars will be null on TestPlan
	                vars.put(varTrim, randString);
	            }
	        }

	        return randString;

	    }

	    /** {@inheritDoc} */
	    @Override
	    public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
	        checkParameterCount(parameters, 2, 3);
	        Object[] values = parameters.toArray();

	        minimum = (CompoundVariable) values[0];
	        maximum = (CompoundVariable) values[1];
	        if (values.length>2){
	            varName = (CompoundVariable) values[2];
	        } else {
	            varName = null;
	        }

	    }

	    /** {@inheritDoc} */
	    @Override
	    public String getReferenceKey() {
	        return KEY;
	    }

	    /** {@inheritDoc} */
	    public List<String> getArgumentDesc() {
	        return desc;
	    }
	    
	    
}
