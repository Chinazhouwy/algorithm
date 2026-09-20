package com.chinazhouwy.algolab.datastructure.linear;

import com.chinazhouwy.algolab.utils.ArrayUtils;

/**
 * 字符串匹配算法。
 *
 * <p>返回模式串在主串中第一次出现的起始下标；匹配失败返回 {@code -1}。</p>
 */
public class MatchArg {

	private MatchArg() {
		// 工具类不提供实例化。
	}

	/**
	 * BF（Brute Force，暴力匹配）算法。
	 *
	 * <p>依次将模式串与主串的每一个可能起点对齐，逐字符比较。
	 * 请在此方法中补充具体匹配逻辑。</p>
	 *
	 * @param text 主串
	 * @param pattern 模式串
	 * @return 模式串第一次出现的下标，匹配失败返回 {@code -1}
	 */
	public static int bfBad(String text, String pattern) {
		int offset = 0;
		for(int i =0; i< text.length();i++){
			if(i+offset > text.length()-1){
				return -1;
			}

			if(pattern.charAt(i) == text.charAt(i+offset)){
				if(i == pattern.length()-1){
					return offset;
				}
			}else{
				offset++;
				i = -1;
			}
		}
		return -1;
	}

	public static int bf(String text, String pattern) {
		if(text == null ||
			pattern == null ||
			text.length() == 0 ||
			pattern.length() == 0 ||
			text.length() < pattern.length()){
				return -1;
		}

		for(int i =0; i<= text.length()-pattern.length();i++){
		 	// for(int j = 0; j < pattern.length();j ++){
			// 	if(pattern.charAt(j) == text.charAt(j+i) && j == pattern.length()-1){
			// 		return i;
			// 	}
			// }
			int j = 0;
			while (j < pattern.length() && pattern.charAt(j) == text.charAt(i + j)) {
				j++;
			}
			if (j == pattern.length()) {
				return i;
			}
		}
		return -1;
	}


	/**
	 * KMP（Knuth-Morris-Pratt）算法。
	 *
	 * <p>先通过模式串计算 next（或 prefix）数组，再利用已匹配部分的信息
	 * 避免主串指针回退。请在此方法中补充具体匹配逻辑。</p>
	 *
	 * @param text 主串
	 * @param pattern 模式串
	 * @return 模式串第一次出现的下标，匹配失败返回 {@code -1}
	 */
	public static int kmp(String text, String pattern) {
		if (text == null || pattern == null) return -1;
		if (pattern.isEmpty()) return 0;
		if (text.length() < pattern.length()) return -1;

		int[] next = buildNext(pattern);
		int i = 0; // 主串指针
    	int j = 0; // 模式串指针

		while (i < text.length()) {
			while(j > 0 && text.charAt(i) != pattern.charAt(j)){
				j = next[j-1];
			}
			if(text.charAt(i) == pattern.charAt(j)){
				j++;
			}
			if(j == pattern.length()){
				return i -j +1;
			}
			i++;
		}

		return -1;
	}

	/**
	 * 构造 KMP 所需的 next（或 prefix）数组。
	 *
	 * @param pattern 模式串
	 * @return 模式串各位置对应的最长相等真前缀与真后缀长度
	 */
	// 	next[i] 表示的是：
	// 模式串前缀 pattern[0..i]
	// 它的“最长相等前后缀”的长度
	// 也就是：前缀和后缀重叠部分的最大长度
	// ababac
	private static int[] buildNext(String pattern) {
		if(pattern == null || pattern.length() == 0){
			return new int[0];
		}

		int[] next = new int[pattern.length()];
		int j = 0;
		for(int i=1;i<pattern.length();i++){
			
			while(j>0 && pattern.charAt(j) != pattern.charAt(i)){
				j = next[j-1];
			}

			if(pattern.charAt(i) == pattern.charAt(j)){
				j ++;
			}

			next[i] = j;
		}

		return next;

	}

	public static int[] buildNextClassic(String pattern){
		int[] lps = buildNext(pattern);
		int[] next = new int[pattern.length()];
		next[0] = -1;
		for(int i = 0; i< next.length; i++){
			next[i] = lps[i-1];
		}
		return next;
	}

	private static int[] buildNextVal (String pattern) {
		    if (pattern == null || pattern.isEmpty()) {
        return new int[0];
    }
		int[] next = buildNextClassic(pattern);
		int[] nextVal = new int[pattern.length()];
		nextVal[0] = -1;
		for(int i =1; i < pattern.length();i++){
			int k = next[i];
			if(k == -1){
				nextVal[i] = -1;
			}else if(pattern.charAt(i) == pattern.charAt(k)){
				nextVal[i] = nextVal[k];
			}else{
				nextVal[i] = k;
			}
		}
		return nextVal;
	}


	public static void main(String[] args) {
		ArrayUtils.printArray(buildNext("ababac"));
		ArrayUtils.printArray(buildNextVal("ababac"));
	}
}
