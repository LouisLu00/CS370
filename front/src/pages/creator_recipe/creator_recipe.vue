<script setup>
  import { useRouter } from 'vue-router';
  import { ref, reactive, onMounted } from 'vue';

  const props = defineProps({});
  const router = useRouter();
  const imageUrls = [
          'https://th.bing.com/th/id/OIP.vpiU6CQtwRufjszmOkDvMgHaFP?w=186&h=132&c=7&r=0&o=5&cb=11&dpr=2&pid=1.7',
          'https://th.bing.com/th/id/OIP.FsUdSSNWDjUM0bAYeHMPAwHaGO?w=186&h=157&c=7&r=0&o=5&cb=11&dpr=2&pid=1.7',
          'https://th.bing.com/th/id/OIP.Vg9r-DAlb6FFY5DzS6MMcAHaFp?w=186&h=142&c=7&r=0&o=5&cb=11&dpr=2&pid=1.7'
        ]
  const num_1 = ref('');
  const num_2 = ref('');
  const num_3 = ref('');
  const num_4 = ref('');
  const num_5 = ref('');
</script>

<template>
  <div class="flex-col page">
    <span class="self-start text">Recipe creator</span>
    <div class="self-stretch section">
      <el-carousel height="11.5rem" motion-blur>
        <el-carousel-item v-for="(imageUrl, index) in imageUrls" :key="index" :autoplay="true">
          <img :src="imageUrl" alt="carousel-image">
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="flex-col self-stretch group">
      <div class="flex-row input view">
        <span class="font text_2">Fish</span>
        <div style="margin: auto;"></div>
        <el-input-number style="align-items: center; margin-right: 0.3rem;" v-model="num_1" :min="1" :max="10"/>
      </div>
      <div class="flex-row input text-wrapper_2 mt-7">
        <span class="font text_2">Strawberry</span>
        <div style="margin: auto;"></div>
        <el-input-number style="align-items: center; margin-right: 0.3rem;" v-model="num_2" :min="1" :max="10"/>
      </div>
      <div class="flex-row justify-start input text-wrapper_1 mt-7">
        <span class="font text_2">Potato</span>
        <div style="margin: auto;"></div>
        <el-input-number style="align-items: center; margin-right: 0.3rem;" v-model="num_3" :min="1" :max="10"/>
      </div>
      <div class="flex-row justify-start input text-wrapper_3 mt-7">
        <span class="font text_2">Drumstick</span>
        <div style="margin: auto;"></div>
        <el-input-number style="align-items: center; margin-right: 0.3rem;" v-model="num_4" :min="1" :max="10"/>
      </div>
      <div class="flex-row justify-start input text-wrapper_5 mt-7">
        <span class="font text_2">Milk</span>
        <div style="margin: auto;"></div>
        <el-input-number style="align-items: center; margin-right: 0.3rem;" v-model="num_5" :min="1" :max="10"/>
      </div>
    </div>
    <div class="flex-col justify-start items-center self-center text-wrapper_4"><span class="text_3">Find</span></div>
  </div>
</template>

<style scoped lang="css">
  .mt-7 {
    margin-top: 0.44rem;
  }
  .page {
    padding: 4.13rem 0.94rem 5.06rem 0.94rem;
    width: 100%;
    overflow-y: auto;
    overflow-x: hidden;
    height: 100%;
  }
  .text {
    margin-left: 0.19rem;
    color: rgb(0, 0, 0);
    font-size: 1.31rem;
    font-family: 'Heiti SC';
    font-weight: 700;
    line-height: 1.31rem;
  }
  .section {
    margin: 4.13rem 0.19rem 0 0.19rem;
    background-color: rgb(255, 255, 255);
    border-radius: 0.19rem;
    height: 11.5rem;
    border-left: 0.063rem;
    border-right: 0.063rem;
    border-top: 0.063rem;
    border-bottom: 0.063rem;
  }
  .group {
    margin-top: 1.56rem;
  }
  .input {
    padding: 1rem 0 1rem;
    background-color: rgb(255, 255, 255);
    border-radius: 0.19rem;
    height: 3.13rem;
    border-left: solid 0.063rem rgb(151, 151, 151);
    border-right: solid 0.063rem rgb(151, 151, 151);
    border-top: solid 0.063rem rgb(151, 151, 151);
    border-bottom: solid 0.063rem rgb(151, 151, 151);
  }
  .view {
    margin-left: 0.13rem;
    margin-right: 0.25rem;
  }
  .font {
    font-size: 1rem;
    font-family: 'Heiti SC';
    line-height: 1rem;
    font-weight: 700;
    color: rgb(0, 0, 0);
  }
  .text_2 {
    margin-left: 0.69rem;
  }
  .text-wrapper_2 {
    margin-right: 0.31rem;
  }
  .text-wrapper_1 {
    margin-right: 0.31rem;
  }
  .text-wrapper_3 {
    margin-right: 0.38rem;
  }
  .text-wrapper_5 {
    margin-right: 0.38rem;
  }
  .text-wrapper_4 {
    margin-top: 4.19rem;
    padding: 1rem 0 0.94rem;
    background-color: rgb(0, 0, 0);
    width: 12.56rem;
  }
  .text_3 {
    color: rgb(255, 255, 255);
    font-size: 0.88rem;
    font-family: 'Heiti SC';
    font-weight: 700;
    line-height: 0.88rem;
  }

  /* 走马灯 */
  .demonstration {
  color: var(--el-text-color-secondary);
  }

  .el-carousel__item h3 {
    color: #475669;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
    text-align: center;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
  }
</style>